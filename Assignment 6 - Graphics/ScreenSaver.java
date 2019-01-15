/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: March 27, 2018
 * Title: Assignment 6 (Part 3 of 3) 
 * Description: 
 * Write an application that simulates a screen saver. 
 * The application will randomly draw 50 ovals to the screen (various sizes and locations), 
 * then it should refresh every 1 second.
For the drawing of the ovals, follow these rules:

Draw on a JPanel imbedded in a JFrame, as before, and set the starting frame size to 800 x 600.
Each run through paintComponent should draw 50 random ovals, which must show up within the JPanel boundaries
For each oval, pick a random color
For each oval, pick a random paint brush thickness between 1 and 10
For each oval, pick a random location within the panel, and a random size (height/width). 
Note that the chosen height/width need to ensure that the oval remains WITHIN the current JPanel. i.e. 
your ovals should be fully viewable on the currently shown panel (the only exception is that your ovals 
might slightly overlap the panel boundaries due to paintbrush thickness)

For the refresh of the screen, you'll need to use class javax.swing.Timer. 
This class sets up a timer event so that the actionPerformed gets called after a given fixed time interval. 
In your actionPerformed method, you can simply call repaint() on your panel, and a new set of ovals will be drawn.
 * */

import java.awt.event.*;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class ScreenSaver
{
   public static void main( String args[] )
   {
      JFrame frame = new JFrame( "Screen Saver" );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      SSPanel ssp = new SSPanel(); 
      frame.add( ssp );
      frame.setSize( 800, 600 ); // set frame size
      frame.setVisible( true ); // display frame
   } // end main
}

class SSPanel extends JPanel implements ActionListener
{
   private int delay = 1000;	// 1000 ms = 1 second
   protected Timer timer;
   
   private int randY = 0;
   private int randX = 0;
   private int verticalDiameter = 0;
   private int horizontalDiameter;

   public SSPanel()
   // Establish the timer for thge panel
   {
      timer = new Timer(delay, this);
      timer.start();
   }

   public void actionPerformed(ActionEvent e)
   // will run when the timer fires (every 'delay' milliseconds)
   {
	repaint();
   }

   public void paintComponent( Graphics g )
   {
	   super.paintComponent( g );
	   Random random = new Random();
	   Graphics2D g2D = (Graphics2D) g;
	   
	   
	   for(int i = 0 ; i < 50; i++)
	   {
		   g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
		   g2D.setStroke(new BasicStroke(random.nextInt(10)+1)); 		// Random thickness between 1 and 10
		   randY = (random.nextInt(getHeight()));				// Random x within panel
		   randX = (random.nextInt(getWidth()));					// Random y within panel 
		   verticalDiameter = random.nextInt(getHeight()-randY);	// Height within boundaries considering start position
		   horizontalDiameter = random.nextInt(getWidth()-randX);	// Width within boundaries considering start position
		   g.drawOval(randX,randY,horizontalDiameter,verticalDiameter);
		   // Note, this generation method causes ovals to be generated less often in the top left quadrant
		   // because the oval extends down and right from the start position
	   } 
   }

}