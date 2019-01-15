public abstract class Player
{
	protected int pNum; 
	
	public Player()
	{
		pNum = -1;
	}
	
	public Player(int p)	// Indicates if player one or two
	{
		pNum = p;
		int x =0;
	}
	
	public abstract int Play(Board b);
	
	public int accessorPNUM()
	{
		return pNum;
	}
	
	public char playToken()
	{
		char token;
		
		if(pNum == 1)
			token = 'X';
		else if(pNum == 2)
			token = 'O';
		else
			token = '*';
		
		return token;
	}
}