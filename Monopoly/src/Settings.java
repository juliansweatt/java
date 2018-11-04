import java.io.Serializable;

public class Settings implements Serializable {
	int playerCount = 0;
	int currentPlayer = 0;
	boolean isNew = true;
	
	public Settings()
	{		
		playerCount = 0;
		currentPlayer = 0;
	}
	
	public void setPlayerCount(int p)
	{
		playerCount = p;
	}
	
	public void setCurrentPlayer(int p)
	{
		currentPlayer = p;
	}
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public int getPlayerCount()
	{
		return playerCount;
	}
	
	public void setIsNew(boolean b)
	{
		isNew = b;
	}
	
	public boolean isNew()
	{
		return isNew;
	}
}
