import java.util.Scanner;

public class humanPlayer extends Player
{
	public humanPlayer()
	{
		super();
	}
	
	public humanPlayer(int p)	// Indicates if player one or two
	{
		super(p);
	}

	public int Play(Board b)
	{
		Scanner s = new Scanner(System.in);
		char playToken;
		boolean captured = true;
		
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
		
		while(captured == true)
		{
			if(b.Assign(playToken,s.nextInt()))
			{
				captured = false;
			}
			else
			{
				System.out.println("You've attempted to make an invalid play.");
				System.out.print("Try again: ");
			}
		}
		
		return 0;
	};
};