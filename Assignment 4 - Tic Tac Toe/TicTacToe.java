/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: Feb 26, 2017
 * Title: Assignment 4 
 * Description: Tic-Tac-Toe Game (Two-Player, CPU or Human Players)
 * */

import java.io.IOException;

public class TicTacToe 
{
	public static void main(String[] args) throws IOException
	{
		if(args.length==0)		// Two Human Players
		{
			int victor = 0;
			Board b = new Board();
			humanPlayer p1 = new humanPlayer(1);
			humanPlayer p2 = new humanPlayer(2);
			
			while(victor == 0)
				{
					b.Print();
					System.out.println("Player 1, please enter a movie (1-9): ");
					p1.Play(b);
					victor = b.victoryCheck(p1.playToken());
					if(victor != 0)
						break;
					b.Print();
					System.out.print("Player 2, please enter a movie (1-9): ");
					p2.Play(b);
					victor = b.victoryCheck(p1.playToken());
				}
			
			b.Print();
			if(victor == 1)
				System.out.println("Player 1 Wins! Game Over!");
			else if(victor == 2)
				System.out.println("Player 2 Wins! Game Over!");
			else
				System.out.println("Game Over! It's a draw.");

		}
		
		
		else if(args.length==1)		// Two Computer Players
		{
			if(!args[0].equals("-c"))	// Input error checking
			{
				System.out.println("Usage:  java TicTacToe [-c [1|2] [-a]]");
				return;
			}
			
			int victor = 0;
			Board b = new Board();
			cpuPlayer p1 = new cpuPlayer(1);
			cpuPlayer p2 = new cpuPlayer(2);
			
			while(victor == 0)		// Reminder: p1 and p2 bear no order in their names
									// Order is in their member data
			{
				b.Print();
				System.out.println("Player 1 (computer) chooses position " + p1.Play(b));
				victor = b.victoryCheck(p1.playToken());
				if(victor != 0)
					break;
				b.Print();
				System.out.println("Player 2 (computer) chooses position " + p2.Play(b));
				victor = b.victoryCheck(p2.playToken());
			}
			
			b.Print();
			if(victor == 1)
				System.out.println("Player 1 Wins! Game Over!");
			else if(victor == 2)
				System.out.println("Player 2 Wins! Game Over!");
			else
				System.out.println("Game Over! It's a draw.");
			
		}
		
		
		else if(args.length==2)			// One Computer, One Human Player
		{
			int victor = 0;
			Board b = new Board();
			humanPlayer p1 = null;
			cpuPlayer p2 = null;
			cpuPlayer px = null;
			
			if(args[1].equals("1") && args[0].equals("-c"))		// CPU is player 1
			{
				p1 = new humanPlayer(2);
				p2 = new cpuPlayer(1);
				
				while(victor == 0)		// Reminder: p1 and p2 bear no order in their names
											// Order is in their member data
				{
					b.Print();
					System.out.println("Player 1 (computer) chooses position " + p2.Play(b));
					victor = b.victoryCheck(p2.playToken());
					if(victor != 0)
						break;
					b.Print();
					System.out.print("Player 2, please enter a movie (1-9): ");
					p1.Play(b);
					victor = b.victoryCheck(p1.playToken());
				}
			}
			
			else if(args[1].equals("2") && args[0].equals("-c"))		// CPU is player 2
			{
				p1 = new humanPlayer(1);
				p2 = new cpuPlayer(2);
				
				while(victor == 0)
				{
					b.Print();
					System.out.print("Player 1, please enter a movie (1-9): ");
					p1.Play(b);
					victor = b.victoryCheck(p1.playToken());
					if(victor != 0)
						break;
					b.Print();
					System.out.println("Player 2 (computer) chooses position " + p2.Play(b));
					victor = b.victoryCheck(p2.playToken());
				}
			}
			
			else if(args[1].equals("-a") && args[0].equals("-c"))		// 2 Advanced CPUs (Extra Credit)
			{
				px = new cpuPlayer(1);
				p2 = new cpuPlayer(2);
				
				while(victor == 0)
				{
					b.Print();
					System.out.println("Player 1 (computer) chooses position " + px.advancedPlay(b));
					victor = b.victoryCheck(px.playToken());
					if(victor != 0)
						break;
					b.Print();
					System.out.println("Player 2 (computer) chooses position " + p2.advancedPlay(b));
					victor = b.victoryCheck(p2.playToken());
				}
				
			}
	
			else								// CPU was requested to be neither 1 or 2 (bad usage)
			{
				System.out.println("Usage:  java TicTacToe [-c [1|2] [-a]]");
    				return;
			}
			
			b.Print();
			if(victor == 1)
				System.out.println("Player 1 Wins! Game Over!");
			else if(victor == 2)
				System.out.println("Player 2 Wins! Game Over!");
			else
				System.out.println("Game Over! It's a draw.");
			
		}
		else if(args.length == 3)							// Extra Credit: Advanced CPUPlayer
		{
			if(args[0].equals("-c")&&(args[1].equals("1")||args[1].equals("2"))&&args[2].equals("-a"))
			{
				int victor = 0;
				Board b = new Board();
				humanPlayer p1 = null;
				cpuPlayer p2 = null;
				
				if(args[1].equals("1"))
				{
					p1 = new humanPlayer(2);
					p2 = new cpuPlayer(1);
					
					while(victor == 0)		// Reminder: p1 and p2 bear no order in their names
											// Order is in their member data
					{
						b.Print();
						System.out.println("Player 1 (computer) chooses position " + p2.advancedPlay(b));
						victor = b.victoryCheck(p2.playToken());
						if(victor != 0)
							break;
						b.Print();
						System.out.print("Player 2, please enter a movie (1-9): ");
						p1.Play(b);
						victor = b.victoryCheck(p1.playToken());
					}
				}
				else if (args[1].equals("2"))
				{
					p1 = new humanPlayer(1);
					p2 = new cpuPlayer(2);
					
					while(victor == 0)
					{
						b.Print();
						System.out.print("Player 1, please enter a movie (1-9): ");
						p1.Play(b);
						victor = b.victoryCheck(p1.playToken());
						if(victor != 0)
							break;
						b.Print();
						System.out.println("Player 2 (computer) chooses position " + p2.advancedPlay(b));
						victor = b.victoryCheck(p2.playToken());
					}
				}
				
				b.Print();
				if(victor == 1)
					System.out.println("Player 1 Wins! Game Over!");
				else if(victor == 2)
					System.out.println("Player 2 Wins! Game Over!");
				else
					System.out.println("Game Over! It's a draw.");
			}
			else
			{
				System.out.println("Usage:  java TicTacToe [-c [1|2] [-a]]");
				return;
			}
		}
		
		else
		{
    			System.out.println("Usage:  java TicTacToe [-c [1|2] [-a]]");
    			return;
    		}
		
	}
}
