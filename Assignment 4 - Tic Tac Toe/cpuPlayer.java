import java.util.Random;

public class cpuPlayer extends Player
{
	public cpuPlayer()
	{
		super();
	}
	
	public cpuPlayer(int p)	// Indicates if player one or two
	{
		super(p);
	}
	
	public int Play(Board b)
	{
		char playToken;
		int loc = -1;
		
		if(pNum == 1)
		{
			playToken = 'X';
		}
		else if(pNum == 2)
		{
			playToken = 'O';
		}
		else
			playToken = '*';
		
		// Priority 1: Take a winning move if available (-1 = no possible win)
		loc = locateWin(b,playToken);
		if(loc != -1)
		{
			b.Assign(playToken,loc);
			return loc;
		}
		
		// Priority 2: Block opponant's win
		char opTok;
		if(playToken == 'X')
			opTok = 'O';
		else if (playToken == 'O')
			opTok = 'X';
		else
			opTok = '*';
		
		loc = locateWin(b,opTok);
		if(loc != -1)
		{
			b.Assign(playToken,loc);
			return loc;
		}
		
		// Priority 3: Take the center square
		if(b.gameBoard[1][1] == ' ')
		{
			loc = 5;
			b.Assign(playToken,loc);
			return loc;
		}
		
		// Priority 4: Random Choice
		loc = -1;
		while( loc == -1)
		{
			Random rand = new Random();
			int indexOne = rand.nextInt(3); 		// Random number between 0 and 2;
			int indexTwo = rand.nextInt(3);
			if(b.gameBoard[indexOne][indexTwo] == ' ')
			{
				if(indexOne == 0 && indexTwo == 0)
					loc = 1;
				else if(indexOne == 0 && indexTwo == 1)
					loc = 2;
				else if(indexOne == 0 && indexTwo == 2)
					loc = 3;
				else if(indexOne == 1 && indexTwo == 0)
					loc = 4;
				else if(indexOne == 1 && indexTwo == 1)
					loc = 5;
				else if(indexOne == 1 && indexTwo == 2)
					loc = 6;
				else if(indexOne == 2 && indexTwo == 0)
					loc = 7;
				else if(indexOne == 2 && indexTwo == 1)
					loc = 8;
				else if(indexOne == 2 && indexTwo == 2)
					loc = 9;
				else loc = -1;
			}
		}
		b.Assign(playToken,loc);
		return loc;
	};
	
	private int locateWin(Board b, char playToken)
	{
		int loc = -1;
		
		// HORIZONTAL CHECKING
		// Row 1
		if(b.gameBoard[0][0] == playToken && b.gameBoard[0][1] == playToken && b.gameBoard[0][2] == ' ')
		{
			loc = 3;
		}
		else if(b.gameBoard[0][1] == playToken && b.gameBoard[0][2] == playToken && b.gameBoard[0][0] == ' ')
		{
			loc = 1;
		}
		else if(b.gameBoard[0][0] == playToken && b.gameBoard[0][2] == playToken && b.gameBoard[0][1] == ' ')
		{
			loc = 2;
		}
		// Row 2
		else if(b.gameBoard[1][0] == playToken && b.gameBoard[1][1] == playToken && b.gameBoard[1][2] == ' ')
		{
			loc = 6;
		}
		else if(b.gameBoard[1][1] == playToken && b.gameBoard[1][2] == playToken && b.gameBoard[1][0] == ' ')
		{
			loc = 4;
		}
		else if(b.gameBoard[1][0] == playToken && b.gameBoard[1][2] == playToken && b.gameBoard[1][1] == ' ')
		{
			loc = 5;
		}
		// Row 3
		else if(b.gameBoard[2][0] == playToken && b.gameBoard[2][1] == playToken && b.gameBoard[2][2] == ' ')
		{
			loc = 9;
		}
		else if(b.gameBoard[2][1] == playToken && b.gameBoard[2][2] == playToken && b.gameBoard[2][0] == ' ')
		{
			loc = 7;
		}
		else if(b.gameBoard[2][0] == playToken && b.gameBoard[2][2] == playToken && b.gameBoard[2][1] == ' ')
		{
			loc = 8;
		}
		
		// VERTICAL CHECKING
		// Col 1
		else if(b.gameBoard[0][0] == playToken && b.gameBoard[1][0] == playToken && b.gameBoard[2][0] == ' ')
		{
			loc = 7;
		}
		else if(b.gameBoard[2][0] == playToken && b.gameBoard[0][0] == playToken && b.gameBoard[1][0] == ' ')
		{
			loc = 4;
		}
		else if(b.gameBoard[1][0] == playToken && b.gameBoard[2][0] == playToken && b.gameBoard[0][0] == ' ')
		{
			loc = 1;
		}
		
		// Col 2
		else if(b.gameBoard[0][1] == playToken && b.gameBoard[1][1] == playToken && b.gameBoard[2][1] == ' ')
		{
			loc = 8;
		}
		else if(b.gameBoard[1][1] == playToken && b.gameBoard[2][1] == playToken && b.gameBoard[0][1] == ' ')
		{
			loc = 2;
		}
		else if(b.gameBoard[0][1] == playToken && b.gameBoard[2][1] == playToken && b.gameBoard[1][1] == ' ')
		{
			loc = 5;
		}
		
		// Col 3
		else if(b.gameBoard[0][2] == playToken && b.gameBoard[1][2] == playToken && b.gameBoard[2][2] == ' ')
		{
			loc = 9;
		}
		else if(b.gameBoard[0][2] == playToken && b.gameBoard[2][2] == playToken && b.gameBoard[1][2] == ' ')
		{
			loc = 6;
		}
		else if(b.gameBoard[1][2] == playToken && b.gameBoard[2][2] == playToken && b.gameBoard[0][2] == ' ')
		{
			loc = 3;
		}
		
		// DAIGONAL CHECKING
		// Dia: /
		else if(b.gameBoard[2][0] == playToken && b.gameBoard[1][1] == playToken && b.gameBoard[0][2] == ' ')
		{
			loc = 3;
		}
		else if(b.gameBoard[2][0] == playToken && b.gameBoard[0][2] == playToken && b.gameBoard[1][1] == ' ')
		{
			loc = 5;
		}
		else if(b.gameBoard[0][2] == playToken && b.gameBoard[1][1] == playToken && b.gameBoard[2][0] == ' ')
		{
			loc = 7;
		}
		
		// Dia: \
		else if(b.gameBoard[0][0] == playToken && b.gameBoard[1][1] == playToken && b.gameBoard[2][2] == ' ')
		{
			loc = 9;
		}
		else if(b.gameBoard[1][1] == playToken && b.gameBoard[2][2] == playToken && b.gameBoard[0][0] == ' ')
		{
			loc = 1;
		}
		else if(b.gameBoard[0][0] == playToken && b.gameBoard[2][2] == playToken && b.gameBoard[1][1] == ' ')
		{
			loc = 5;
		}
		else
		{
			loc = -1;
		}

		return loc; 
	}
	
	public int advancedPlay(Board b)
	{
		char playToken;
		int loc = -1;
		
		if(pNum == 1)
		{
			playToken = 'X';
		}
		else if(pNum == 2)
		{
			playToken = 'O';
		}
		else
			playToken = '*';
		
		// Priority 1: Take a winning move if available (-1 = no possible win)
		loc = locateWin(b,playToken);
		if(loc != -1)
		{
			b.Assign(playToken,loc);
			return loc;
		}
				
		// Priority 2: Block opponant's win
		char opTok;
		if(playToken == 'X')
			opTok = 'O';
		else if (playToken == 'O')
			opTok = 'X';
		else
			opTok = '*';
				
		loc = locateWin(b,opTok);
		if(loc != -1)
		{
			b.Assign(playToken,loc);
			return loc;
		}
		
		// Priority 3: Play spots while  don't eventually result in a loss
		// Center priority:
		if(b.gameBoard[1][1] == ' ')			// Claim center if possible
		{
			loc = 5;
			b.Assign(playToken,loc);
			return loc;
		}
		
		boolean row1 = true;
		boolean row2 = true;
		boolean row3 = true;
		boolean col1 = true;
		boolean col2 = true;
		boolean col3 = true;
		boolean dia1 = true;
		boolean dia2 = true;
		
		// BOOKMARK: Advanced sorting not working properly
		/*
		boolean index1 = true;
		boolean index2 = true;
		boolean index3 = true;
		boolean index4 = true;
		boolean index5 = true;
		boolean index6 = true;
		boolean index7 = true;
		boolean index8 = true;
		boolean index9 = true;
		*/
		
		// Oppose The 1 corner 1 side strategy 
		/*
		if(b.gameBoard[0][0] == opTok || b.gameBoard[0][2] == opTok || b.gameBoard[2][0] == opTok || b.gameBoard[2][2] == opTok)
		{
			if(b.gameBoard[0][0] == opTok)
			{
				if(b.gameBoard[2][1] == playToken || b.gameBoard[1][2] == playToken)
				{
					index8 = false;
					index6 = false;
				}
			}
			
			if(b.gameBoard[0][2] == opTok)
			{
				if(b.gameBoard[1][0] == playToken || b.gameBoard[2][1] == playToken)
				{
					index4 = false;
					index8 = false;
				}
			}
			
			if(b.gameBoard[2][0] == opTok)
			{
				if(b.gameBoard[0][1] == playToken || b.gameBoard[1][2] == playToken)
				{
					index2 = false;
					index6 = false;
				}
			}
			
			if(b.gameBoard[2][2] == opTok)
			{
				if(b.gameBoard[1][0] == playToken || b.gameBoard[0][1] == playToken)
				{
					index4 = false;
					index2 = false;
				}
			}
		}
		*/
			
		// Row Validation
		if(b.gameBoard[0][0] == opTok || b.gameBoard[0][1] == opTok || b.gameBoard[0][2] == opTok)
			row1 = false;
		if(b.gameBoard[1][0] == opTok || b.gameBoard[1][1] == opTok || b.gameBoard[1][2] == opTok)
			row2 = false;
		if(b.gameBoard[2][0] == opTok || b.gameBoard[2][1] == opTok || b.gameBoard[2][2] == opTok)
			row3 = false;
		
		// Column Validation
		if(b.gameBoard[0][0] == opTok || b.gameBoard[1][0] == opTok || b.gameBoard[2][0] == opTok)
			col1 = false;
		if(b.gameBoard[0][1] == opTok || b.gameBoard[1][1] == opTok || b.gameBoard[2][1] == opTok)
			col2 = false;
		if(b.gameBoard[0][2] == opTok || b.gameBoard[1][2] == opTok || b.gameBoard[2][2] == opTok)
			col3 = false;
		
		// Diagonal Validation
		if(b.gameBoard[0][2] == opTok || b.gameBoard[1][1] == opTok || b.gameBoard[2][0] == opTok) // /
			dia1 = false;
		if(b.gameBoard[0][0] == opTok || b.gameBoard[1][1] == opTok || b.gameBoard[2][2] == opTok) // \
			dia2 = false;
		
		loc = -1;
		int iterator = 0;
		while( loc == -1 &&(iterator <=9))
		{
			Random rand = new Random();
			int indexOne = rand.nextInt(3); 		// Random number between 0 and 2;
			int indexTwo = rand.nextInt(3);
			if(b.gameBoard[indexOne][indexTwo] == ' ')
			{
				if((indexOne == 0 && indexTwo == 0) && (col1|| row1 || dia2))
						loc = 1;
				else if((indexOne == 0 && indexTwo == 1) && (col2|| row1))
						loc = 2;
				else if((indexOne == 0 && indexTwo == 2) && (col3|| row1 || dia1))
						loc = 3;
				else if((indexOne == 1 && indexTwo == 0) && (col1|| row2))
						loc = 4;
				else if((indexOne == 1 && indexTwo == 1) && (col2|| row2 || dia2 || dia1))
						loc = 5;
				else if((indexOne == 1 && indexTwo == 2) && (col3|| row2))
						loc = 6;
				else if((indexOne == 2 && indexTwo == 0) && (col1|| row3 || dia1))
						loc = 7;
				else if((indexOne == 2 && indexTwo == 1) && (col2|| row3))
						loc = 8;
				else if((indexOne == 2 && indexTwo == 2) && (col3|| row3 || dia2))
						loc = 9;
				else loc = -1;
				
				iterator++;						// If all 9 spots can't win, exit and random
			}
		}
		
		if(loc == -1)							// Completely random choice (if all else fails)
		{
			while( loc == -1)
			{
				Random rand = new Random();
				int indexOne = rand.nextInt(3); 		// Random number between 0 and 2;
				int indexTwo = rand.nextInt(3);
				if(b.gameBoard[indexOne][indexTwo] == ' ')
				{
					if(indexOne == 0 && indexTwo == 0)
						loc = 1;
					else if(indexOne == 0 && indexTwo == 1)
						loc = 2;
					else if(indexOne == 0 && indexTwo == 2)
						loc = 3;
					else if(indexOne == 1 && indexTwo == 0)
						loc = 4;
					else if(indexOne == 1 && indexTwo == 1)
						loc = 5;
					else if(indexOne == 1 && indexTwo == 2)
						loc = 6;
					else if(indexOne == 2 && indexTwo == 0)
						loc = 7;
					else if(indexOne == 2 && indexTwo == 1)
						loc = 8;
					else if(indexOne == 2 && indexTwo == 2)
						loc = 9;
					else loc = -1;
				}
			}
		}
		
		b.Assign(playToken,loc);
		return loc;
	}
}