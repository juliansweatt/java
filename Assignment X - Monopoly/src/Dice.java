import java.util.Random;

public class Dice 
{
	public Dice()
	{
		
	}
	
	public int rollDice()
	{
		Random rand = new Random();
		return (rand.nextInt(6)+1);
	}
}
