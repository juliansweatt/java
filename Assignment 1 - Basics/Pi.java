/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: Jan 25, 2017
 * Title: Assignment 1 (Part 1 of 3) Pi
 * Description: Approximates pi using the "pi = 4 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + ..."
 * 				method to the precision the user enters.
 * */

import java.util.Scanner;

public class Pi {
	public static void main(String[] args)
	{
		int n;
		double pi = 4.0;

		Scanner s = new Scanner(System.in);

		System.out.println("Excercise 5.20: 'Approximating Pi'");
		System.out.printf("Compute how many terms of the series? ");

		n = s.nextInt();

		for(int i = 1; i <= n; i++)
		{
			int signChange = 1;
			if(i % 2 == 0)
			{
				signChange = -1;
			}
			
			if( i == 1)
			{
				pi = 4.0; 
			}
			else
			{
				pi = pi + ((4.0/((2*i)-1))*signChange);
			}

			System.out.printf("%-8d", i);
			System.out.println(pi);
		}

		s.close();
	}
}
