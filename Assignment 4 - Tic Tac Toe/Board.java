
public class Board {
	protected char [][] gameBoard = new char [3][3];

	  public Board()
	  {
		 for(int i = 0; i < 3; i++)
		 {
			 for(int j = 0; j < 3; j++)
				 gameBoard[i][j] = ' ';
		 }
	  }
	  
	  public void Print()
	  {
		  System.out.println("Game Board:                Positions:");
		  System.out.println();
		  
		  System.out.print(" " + gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2] + " ");
		  System.out.print("                ");
		  System.out.println(" 1 | 2 | 3 ");
		  
		  System.out.println("-----------                -----------");
		  
		  System.out.print(" " + gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2] + " ");
		  System.out.print("                ");
		  System.out.println(" 4 | 5 | 6 ");
		  
		  System.out.println("-----------                -----------");
		  
		  System.out.print(" " + gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2] + " ");
		  System.out.print("                ");
		  System.out.println(" 7 | 8 | 9 ");
		  
		  System.out.println();
	  };
	  
	  public int victoryCheck(char c)		// Returns player number of (1 or 2) of victor, or 0 if no victor. Takes in character to be victor checked
	  {
		  int victor = 0;
		  
		  // Horizontal Victories
		  if(gameBoard[0][0] == c && gameBoard[0][1] == c && gameBoard[0][2] == c)
		  {
			  if(c=='X')
				  victor = 1;
			  else if(c=='O')
				  victor = 2;
		  }
		  
		  else if(gameBoard[1][0] == c && gameBoard[1][1] == c && gameBoard[1][2] == c)
		  {
			  if(c=='X')
				  victor = 1;
			  else if(c=='O')
				  victor = 2;
		  }
		  
		  else if(gameBoard[2][0] == c && gameBoard[2][1] == c && gameBoard[2][2] == c)
		  {
			  if(c=='X')
				  victor = 1;
			  else if(c=='O')
				  victor = 2;
		  }
		  
		  // Vertical Victories
		  else if(gameBoard[0][0] == c && gameBoard[1][0] == c && gameBoard[2][0] == c)
		  {
			  if(c=='X')
				  victor = 1;
			  else if(c=='O')
				  victor = 2;
		  }
		  
		  else if(gameBoard[0][1] == c && gameBoard[1][1] == c && gameBoard[2][1] == c)
		  {
			  if(c=='X')
				  victor = 1;
			  else if(c=='O')
				  victor = 2;
		  }
		  
		  else if(gameBoard[0][2] == c && gameBoard[1][2] == c && gameBoard[2][2] == c)
		  {
			  if(c=='X')
				  victor = 1;
			  else if(c=='O')
				  victor = 2;
		  }
		  
		  // Diagonal Victories
		  else if(gameBoard[0][0] == c && gameBoard[1][1] == c && gameBoard[2][2] == c)
		  {
			  if(c=='X')
				  victor = 1;
			  else if(c=='O')
				  victor = 2;
		  }
		  
		  else if(gameBoard[0][2] == c && gameBoard[1][1] == c && gameBoard[2][0] == c)
		  {
			  if(c=='X')
				  victor = 1;
			  else if(c=='O')
				  victor = 2;
		  }
		  
		  else if(gameBoard[0][0] != ' ' && gameBoard[0][1] != ' ' && gameBoard[0][2] != ' ' && gameBoard[1][0] != ' ' && gameBoard[1][1] != ' ' &&gameBoard[1][2] != ' ' && gameBoard[2][0] != ' ' && gameBoard[2][1] != ' ' && gameBoard[2][2] != ' ')
			  victor = -1;
		  
		  return victor; 
	  };
	  
	  public boolean Assign(char c, int position)
	  {
		  boolean valid;
		  
		  if(position >=1 && position <= 9)
		  {
			  valid = true;
			  switch(position)
			  {
			  case 1:
				  if(gameBoard[0][0] == ' ')
				  {
					  gameBoard[0][0] = c;
				  }
				  else valid = false; 
				  break;
			  case 2:
				  if(gameBoard[0][1] == ' ')
				  {
					  gameBoard[0][1] = c;
				  }
				  else valid = false; 
				  break;
			  case 3:
				  if(gameBoard[0][2] == ' ')
				  {
					  gameBoard[0][2] = c;
				  }
				  else valid = false; 
				  break;
			  case 4:
				  if(gameBoard[1][0] == ' ')
				  {
					  gameBoard[1][0] = c;
				  }
				  else valid = false; 
				  break;
			  case 5:
				  if(gameBoard[1][1] == ' ')
				  {
					  gameBoard[1][1] = c;
				  }
				  else valid = false; 
				  break;
			  case 6:
				  if(gameBoard[1][2] == ' ')
				  {
					  gameBoard[1][2] = c;
				  }
				  else valid = false; 
				  break;
			  case 7:

				  if(gameBoard[2][0] == ' ')
				  {
					  gameBoard[2][0] = c;
				  }
				  else valid = false; 
				  break;
			  case 8:
				  if(gameBoard[2][1] == ' ')
				  {
					  gameBoard[2][1] = c;
				  }
				  else valid = false; 
				  break;
			  case 9:
				  if(gameBoard[2][2] == ' ')
				  {
					  gameBoard[2][2] = c;
				  }
				  else valid = false; 
				  break;
			  default:
				  valid = false;
			  }
		  }
		  else
			  valid = false; 
		  
		  return valid;
	  }
};
