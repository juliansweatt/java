/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: March 27, 2018
 * Title: Assignment 6 (Part 2 of 3) 
 * Description: 
 * 	Write an application that draws a snowman. The snowman's exact size and position will be based on given proportions and centered in the current JPanel. Details:
Build your application as a JPanel embedded in a JFrame. Set the frame's starting size as 600 x 400. The snowman is drawn on the JPanel
The main body of the snowman should consist of three circles, sitting on top of each other
The bottom circle takes up half of the snowman's height. The middle and top circle take up 2/3 and 1/3 of the remaining height, respectively
Each of these circles is drawn with a random color
The full snowman should take up 3/4 of the panel's height, and it should be centered horizontally and vertically in the panel. (Note: This means the exact locations and sizes of circles will change if the panel is resized)
The snowman should have two eyes (black) drawn in the top circle, aligned proportionally somewhere near the top of the head (i.e. where eyes would naturally go)
The snowman should have two arms (black) drawn coming out of the top part of the middle circle. They should just be lines that stick out from the middle "body" section, angled upwards. Draw these so that they adjust proportionally as the window is resized. (They should always fully appear in the actual panel!)
NO portion of the drawing should ever leave the viewable area of the panel
 * */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snowman
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame( "Snowman" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	    SnowPanel sp = new SnowPanel(); 
	    frame.add( sp );
	    frame.setSize( 600, 400 ); 
	    frame.setVisible( true ); 
	}
}

class SnowPanel extends JPanel
{
	private double totalHeight;
	private double bottomDiameter;
	private double middleDiameter;
	private double headDiameter;
	private double eyeDiameter;
	private double bottomCenterY;
	private double middleCenterY;
	private double headCenterY;
	private int centerX;
	
   public void paintComponent( Graphics g )
   {
	super.paintComponent( g ); 					// call superclass's paintComponent 
	Random random = new Random(); 				// get random number generator
	
	totalHeight = ((0.75)*getHeight());
	bottomDiameter = (totalHeight)/2;
	
	if(bottomDiameter > getWidth())				// Prevent snowman out of bounds horizontally
	{
		bottomDiameter = getWidth();
	}
	
	middleDiameter = ((bottomDiameter)*(2.0/3.0));
	headDiameter = (1.0/3.0)*(bottomDiameter);
	eyeDiameter = headDiameter*.1;
	
	centerX = getWidth()/2;
	
	bottomCenterY = getHeight()-(bottomDiameter/2.0)-(getHeight()*(1.0/8.0));
	middleCenterY = bottomCenterY-(bottomDiameter/2.0)-(middleDiameter/2.0);
	headCenterY = middleCenterY-(middleDiameter/2.0)-(headDiameter/2.0);

	// Bottom Oval
	g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
	g.drawOval((int)(centerX-(bottomDiameter/2)), (int)(bottomCenterY-(bottomDiameter)/2), (int)(bottomDiameter), (int)bottomDiameter); // Note this x and y is the upper left framing rectangle, dimensions are diameters
	// Middle Oval
	g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
	g.drawOval((int)(centerX-(middleDiameter/2)), (int)(middleCenterY-(middleDiameter/2)), (int)(middleDiameter), (int)middleDiameter);
	// Head Oval
	g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
	g.drawOval((int)(centerX-(headDiameter/2)), (int)(headCenterY-(headDiameter/2)), (int)(headDiameter), (int)headDiameter); // Bookmark
	// Eyes
	// Left Eye
	g.setColor(new Color(0,0,0));
	g.fillOval((int)((centerX)-(headDiameter/4)), ((int)(headCenterY-(headDiameter/4))), (int)eyeDiameter,(int)eyeDiameter);
	// Right Eye
	g.fillOval((int)((centerX)+(headDiameter/4)-eyeDiameter), ((int)(headCenterY-(headDiameter/4))), (int)eyeDiameter,(int)eyeDiameter);
	// Arms
	// Left Arm
	g.drawLine((int)((centerX)-(middleDiameter/4)), ((int)(middleCenterY-(middleDiameter/4))), (int)((centerX)-(middleDiameter/4)-middleDiameter/2) , (int)(middleCenterY-(middleDiameter/4)-middleDiameter/3));
	// Right Arm
	g.drawLine((int)((centerX)+(middleDiameter/4)), ((int)(middleCenterY-(middleDiameter/4))), (int)((centerX)+(middleDiameter/4)+middleDiameter/2) , (int)(middleCenterY-(middleDiameter/4)-middleDiameter/3));
   }

}
