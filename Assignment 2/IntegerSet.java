/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: Feb 2, 2017
 * Title: Assignment 2 (Part 1 of 2)
 * Description: Stores integer values 0-100 as boolean values.
 * 				Allows for union & intersection operations/comparisons.
 * */


public class IntegerSet 
{
	private boolean [] IntSet;
	
	public IntegerSet()
	{
		IntSet = new boolean [101];
		for(int i = 0; i <= 100; i++)
		{
			IntSet[i] = false;
		}
	};
	
	public IntegerSet union(IntegerSet iSet)
	{
		IntegerSet USet = new IntegerSet();
		
		for(int i = 0; i <= 100; i++) 
		{
			if(this.IntSet[i] == true || this.IntSet[i] == true)
			{
				USet.IntSet[i] = true;
			}
		}
		return USet;
	};
	
	public IntegerSet intersection(IntegerSet iSet)
	{
		IntegerSet USet = new IntegerSet();
		
		for(int i = 0; i <= 100; i++) 
		{
			if(this.IntSet[i] == true && iSet.IntSet[i] == true)
			{
				USet.IntSet[i] = true;
			}
		}
		return USet;
		
	};
	
	public IntegerSet insertElement(int data)
	{
		this.IntSet[data] = true;
		return this;
	};
	
	public IntegerSet deleteElement(int data)
	{
		this.IntSet[data] = false;
		return this;
	};
	
	public boolean isEqualTo(IntegerSet iSet)
	{
		boolean answer = true;
		
		for(int i = 0; i <= 100; i++)
		{
			if(this.IntSet[i] != iSet.IntSet[i])
			{
				answer = false;
			}
		}
		
		return answer;
	};
	
	public String toString()
	{
		String printMe = new String();
		boolean isEmpty = true;
		
		for(int i = 0; i <= 100; i++) 
		{
			if(this.IntSet[i] == true)
			{
				printMe = new String(printMe + " " + i);
				isEmpty = false; 
			}
		}
		
		if(isEmpty == true)
		{
			printMe = new String("---");
		}
		
		return printMe;
	};
	
}