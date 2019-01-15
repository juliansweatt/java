/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: Feb 2, 2017
 * Title: Assignment 2 (Part 2 of 2) 
 * Description: Allows addition, subtraction, multiplication, and division of fractions (simplified)
 */

public class Fraction
{
  private int numerator = 0;		// numerator (and keeps sign)
  private int denominator = 1;		// always stores positive value

  public Fraction()
  {
  }

  public Fraction(int n, int d)
  {
    if (set(n,d)==false)
	set(0,1);
  }

  public boolean set(int n, int d)
  {
    if (d > 0)
    {
	numerator = n;
	denominator = d;
	return true;
    }
    else
	return false;
  }
  
  public String toString()
  {
    return (numerator + "/" + denominator);
  }

  public int getNumerator()
  {
    return numerator;
  }

  public int getDenominator()
  {
    return denominator;
  }

  public double decimal()
  {
    return (double)numerator / denominator;
  }
  
  // Added methods below:
  
  public Fraction simplify()
  {
	  int n = this.getNumerator();
	  int d = this.getDenominator();
	  
	  if(n == 0)
	  {
		  d = 1;
	  }
	  else
	  {
		  for(int i = d; i > 0; i--)
		  {
			  if(n % i == 0 && d % i == 0)
			  {
				  n = n / i;
				  d = d / i;
			  }
		  }
	  }
	  
	  if(d < 0)
	  {
		  d = d * -1;
		  n = n * -1;
	  }
	  
	  Fraction temp = new Fraction(n,d);
	  return temp;
  }
  
  public Fraction add(Fraction f)
  {
	  int n1 = this.getNumerator();
	  int d1 = this.getDenominator();
	  int n2 = f.getNumerator();
	  int d2 = f.getDenominator();
	  int n = 0, d = 0;
	  
	  n = ((n1*d2)+(n2*d1));
	  d = (d1*d2);
	  
	  if(d < 0)
	  {
		  d = d * -1;
		  n = n * -1;
	  }
	  
	  Fraction temp = new Fraction(n,d);
	  temp = temp.simplify();
	  return temp;
  }
  
  public Fraction subtract(Fraction f)
  {
	  int n1 = this.getNumerator();
	  int d1 = this.getDenominator();
	  int n2 = f.getNumerator();
	  int d2 = f.getDenominator();
	  int n = 0, d = 0;
	  
	  n = ((n1*d2)-(n2*d1));
	  d = (d1*d2);
	  
	  if(d < 0)
	  {
		  d = d * -1;
		  n = n * -1;
	  }
	  
	  Fraction temp = new Fraction(n,d);
	  temp = temp.simplify();
	  return temp;
  }
  
  public Fraction multiply(Fraction f)
  {
	  int n1 = this.getNumerator();
	  int d1 = this.getDenominator();
	  int n2 = f.getNumerator();
	  int d2 = f.getDenominator();
	  int n = 0, d = 0;
	  
	  n = n1*n2;
	  d = d1*d2;
	  
	  if(d < 0)
	  {
		  d = d * -1;
		  n = n * -1;
	  }
	  
	  Fraction temp = new Fraction(n,d);
	  temp = temp.simplify();
	  return temp;
  }
  
  public Fraction divide(Fraction f) 
  {
	  int n1 = this.getNumerator();
	  int d1 = this.getDenominator();
	  int n2 = f.getNumerator();
	  int d2 = f.getDenominator();
	  int n = 0, d = 0;
	  
	  n = n1*d2;
	  d = d1*n2;
	  
	  if(d < 0)
	  {
		  d = d * -1;
		  n = n * -1;
	  }
	  
	  Fraction temp = new Fraction(n,d);
	  temp = temp.simplify();
	  return temp;
  }

}