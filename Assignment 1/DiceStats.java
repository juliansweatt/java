/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: Jan 25, 2017
 * Title: Assignment 1 (Part 3 of 3) Pi
 * Description: User inputs the amount of fair six sided dice to roll, and how
 * 				many times to roll them. These rolls are then randomly generated
 * 				and printed with their percentage sum values.
 * */

import java.util.Scanner;
import java.util.Random;

public class DiceStats {
	public static void main(String[] args)
	{
		int dice;
		int rolls;
		
		int maxSum; 
		
		Scanner s = new Scanner(System.in);

		System.out.print("How many dice will constitute one roll? ");
		dice = s.nextInt();
		
		System.out.print("How many rolls? ");
		rolls = s.nextInt();
		
		maxSum = dice * 6;
		int [] frequency;
		frequency = new int[maxSum+1];
		
		Random rand = new Random();
		for(int i = 0; i < rolls; i++)
		{
			int rollSum = 0;
			for(int j = 0; j < dice; j++)
			{
				rollSum = rollSum + (rand.nextInt(6)+1);
			}
			frequency[rollSum] = frequency[rollSum] + 1;
		}
		
		System.out.println();
		
		// Printout
		System.out.println("Sum     # of times      Percentage");
		System.out.println();
		for(int i = dice; i < maxSum+1; i++)
		{
			System.out.printf("%-8d", i);
			System.out.printf("%-16d", frequency[i]);
			double individualSum = frequency[i];
			double percentage = ((individualSum/rolls)*100.0);
			System.out.printf("%.2f", percentage);
			System.out.print(" %");
			System.out.println();
		}

		s.close();
	}

}
