/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: Jan 25, 2017
 * Title: Assignment 1 (Part 2 of 3) Reverse
 * Description: Takes in a positive long int from the user, outputs the reverse.
 * 				Note, the reverse is calculated as a long, not a string, so values
 * 				such as 0002 will return as 2, rather than 2000.
 * */

import java.util.Scanner;

public class Reverse 
{
	public static void main(String[] args)
	{
		long original = 1; 
		long reversed = 0; 
		Scanner s = new Scanner(System.in);
		
		while(original != 0)
		{
			System.out.print("Please enter a long integer (0 to quit): ");
			original = s.nextLong();
			
			if(original != 0)
			{
				reversed = reverseDigits(original);
				System.out.println("The number reversed is: " + reversed);
			}
		}
		
		System.out.println("Goodbye!");
		s.close();
	}
	
	static long reverseDigits(long original)
	{
		long reversed = 0;
		
		while(original != 0)
		{
			reversed = reversed * 10 + original % 10;
			original = original / 10; 
		}
		
		return reversed;
	}
}