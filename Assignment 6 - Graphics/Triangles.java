/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: March 27, 2018
 * Title: Assignment 6 (Part 1 of 3) 
 * Description: 
 * 	Write an application that draws random triangles. Write your application
 *  so that the drawing is done on a JPanel, embedded in a JFrame with starting size 500 x 500. 
 *  (Note that JFrames can be resized by the user, just like normal windows in standard computer applications). 
 *  On your JPanel, you will draw 5 random triangles, each filled with a randomly chosen color. 
 *  To choose a random color, choose each of the RGB values randomly (range 0-255). 
 *  Use class GeneralPath to create the triangles, and method fill from class Graphics2D to draw them.
	
	The triangle end points should be chosen chosen so that they could be any valid points within the JPanel.
	Note that this is not always in a range of 500 x 500 -- if the application frame is expanded, the panel
	area will be larger. Do your drawing in method paintComponent. (Notice that this means that refreshes to the
	panel will result in new random triangles. For example, resize the window and the internal components will
	be redrawn, because paintComponent will be called again). 
 * */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Triangles
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame( "Triangle" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	      TrianglePanel tp = new TrianglePanel(); 
	      frame.add( tp );
	      frame.setSize( 500, 500 ); // set frame size
	      frame.setVisible( true ); // display frame
	}
}

class TrianglePanel extends JPanel
{
	private int width;
	private int height;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	
   public void paintComponent( Graphics g )
   {
	super.paintComponent( g ); // call superclass's paintComponent 
	Random random = new Random(); // get random number generator
	
	width = getWidth();
	height = getHeight();
	
	for(int i = 0; i < 6; i++)
	{
		Graphics2D g2d = (Graphics2D) g;
		GeneralPath triangle = new GeneralPath();
		
		x1 = random.nextInt(width);
		y1 = random.nextInt(height);
		
		x2 = random.nextInt(width);
		y2 = random.nextInt(height);
		
		x3 = random.nextInt(width);
		y3 = random.nextInt(height);
		
		triangle.moveTo(x1, y1);
		triangle.lineTo(x2, y2);
		triangle.lineTo(x3, y3);
		
		triangle.closePath();
		
		g2d.setColor(new Color(random.nextInt(256),
			random.nextInt(256), random.nextInt(256)));
		
		g2d.fill(triangle);
	}
   }

}