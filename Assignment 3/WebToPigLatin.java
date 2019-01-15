/**
 * This class translates text and HTML files to Pig Latin.
 *
 * <p>Command has two arguments
 * <br><code>inputFile</code>
 * <br><code>exportFile</code> <br>
 *
 * <p>Proper use:
 * <br><code>WebToPigLatin input.html output.html</code> <br>
 * 
 * <p>Follows the following rules:
 * <br>A word to be translated is a consecutive sequence of letters (a-z, A-Z) or apostrophes, containing at least one vowel (or y in a vowel position). Examples: Zebra , doesn't , apple, rhythm
If a word starts with a vowel, the Pig Latin version is the original word with "way" added to the end
If a word starts with a consonant, or a series of consecutive consonants, the Pig Latin version transfers all consonants up to the first vowel to the end of the word, and adds "ay" to the end.
The letter 'y' should be treated as a consonant if it is the first letter of a word, but treated as a vowel otherwise.
If the original word is capitalized, the new Pig Latin version of the word should be capitalized in the first letter (i.e. the previous capital letter may not be capitalized any more).
 *
 *<p>Assignment Details:
 *<br>Title: Assignment 3
 *<br>Professor: Robert Myers
 *<br>Due Date: Thursday, Feb 15
 *
 * @version     1.0, Feb 2018
 * @author    Julian Sweatt  sweatt@cs.fsu.edu
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;

public class WebToPigLatin
{
    public static void main(String[] args) throws IOException
    {
    	// Setting up input/output capture
    	if(args.length!=2)
    	{
    		System.out.println("Usage: java WebToPigLatin inputFile outputFile");
    		System.out.println("Must have two command-line parameters");
    		return;
    	}
    	File infile = new File(args[0]);
    	File outfile = new File(args[1]);
    	
    	FileReader reader = null;
		try {
			reader = new FileReader(infile);
		} catch (FileNotFoundException e) {
			System.out.println("The input file does not exist in the specified directory.");
			System.out.println("Failed to launch. Try again.");
		} 
		
	FileWriter writer = new FileWriter(outfile); 
	// End of input/output setup
	
    int readInt;
    int counter = 0;
    char readChar;
    char [] targetedInput = new char[0];
    //boolean inWord = false;	//Differentiates if reading in formatting tags or words
	
	while( (readInt = reader.read() )!=-1) 
	{
		readChar = (char)readInt; //Converts input from int to char
		
		if(readChar == '<')
		{
			if(targetedInput.length>0)
			{
				writer.write(Pig(targetedInput));
				counter = 0;
				targetedInput = new char[0];
			}
			
			writer.write(readChar); // Prints < skipping translation
			
			readInt = reader.read(); // Reads in next character as int
			readChar = (char)readInt; // Converts next character to char
			
			while(readChar != '>') // While still in the formatting tag, print without translations
			{
				writer.write(readChar);
				readInt = reader.read();
				readChar = (char)readInt;
			}
			
			// At this point readChar must contain >
			// So print and return to the outer while loop
			writer.write(readChar);
		}
		
		else if(readChar == '&')
		{
			if(targetedInput.length>0)
			{
				writer.write(Pig(targetedInput));
				counter = 0;
				targetedInput = new char[0];
			}
			
			writer.write(readChar); // Prints & skipping translation
			
			readInt = reader.read(); // Reads in next character as int
			readChar = (char)readInt; // Converts next character to char
			
			while(readChar != ';') // While still in the formatting tag, print without translations
			{
				writer.write(readChar);
				readInt = reader.read();
				readChar = (char)readInt;
			}
			
			// At this point readChar must contain ;
			// So print and return to the outer while loop
			writer.write(readChar);
		}
		
		else if(isPunctuation(readChar))
		{
			if(targetedInput.length > 0)
				writer.write(Pig(targetedInput));	// Print translation word
			writer.write(readChar);		// Print the punctuation
			counter = 0;
			targetedInput = new char[0];
		}
		
		else
		{
			if(!Character.isWhitespace(readChar))			// If no space, add on to word and exit to main while loop
			{
				if(counter == targetedInput.length)
				{
					targetedInput = Arrays.copyOf(targetedInput, targetedInput.length+1);
				}
				
				targetedInput[counter] = readChar;
				counter++;
			}
			else if(Character.isWhitespace(readChar)) 	// If whitespace, close word and translate
			{
				if(targetedInput.length > 0)
					writer.write(Pig(targetedInput));	// Print translation word
				writer.write(readChar);		// Print the space
				counter = 0;
				targetedInput = new char[0];
			}

		}
	}
	
    	reader.close();
    	writer.flush();
    	writer.close();
    	
    	System.out.println("Success! " + args[0] + " has been translated to Pig Latin and saved to " + args[1]);
    }

	private static boolean isPunctuation(char readChar) {
		boolean answer = false;
		if(readChar == ',' || readChar == '.' || readChar == '!' || readChar == '?' || readChar == ':' || readChar == '`' || readChar == '%' || readChar == '*' || readChar == '(' || readChar == ')' || readChar == '[' || readChar == ']' || readChar == '{' || readChar == '}' || readChar == '#')
		{
			answer = true;
		}
		return answer;
	}

	private static char[] Pig(char[] translationTarget) {
		// Establishing word traits
		char[] translated = new char[translationTarget.length];
		boolean containsDigit = false;
		boolean containsVowel = false;
		boolean beginsWithVowel = false;
		
		for(int i = 0; i<translationTarget.length; i++)
		{
			if(Character.isDigit(translationTarget[i]))
			{
				containsDigit = true;
			}
			
			if(isVowel(translationTarget[i],i))
			{
				containsVowel = true;
			}
			
		}
		beginsWithVowel = isVowel(translationTarget[0],0);
		// End Establishing Word Traits
		
		if(containsDigit == false && containsVowel == true)
		{
			// Translation Below (Not Done)
			
			if(beginsWithVowel == true)
			{
				int initialSize = translationTarget.length;
				translated = Arrays.copyOf(translationTarget, initialSize+3);
				translated[initialSize] = 'w';
				translated[initialSize+1] = 'a';
				translated[initialSize+2] = 'y';
			}
			else if(beginsWithVowel == false)
			{
				int firstVowelIndex = 0;
				int numCon = 0;
				int initialSize = translationTarget.length;
				char [] consonants = new char [0];
				boolean vowFound = false;
				boolean isUpper = false; // Becomes true if the first consonant is capitalized
				
				for(int i = 0; i<translationTarget.length && vowFound==false; i++)
				{
					if(isVowel(translationTarget[i],i))
					{
						firstVowelIndex = i;
						vowFound = true;
					}
					if(vowFound == false)
					{
						if(numCon == consonants.length)
						{
							consonants = Arrays.copyOf(consonants, consonants.length+1);
						}
						
						consonants[numCon] = translationTarget[i];
						isUpper = (Character.isUpperCase(consonants[0]));
						numCon++;
					}
				}
				if(isUpper)
					consonants[0] = Character.toLowerCase(consonants[0]);
				
				for(int i = firstVowelIndex; i < (translationTarget.length);i++)
				{
					if(isUpper && i == firstVowelIndex)
					{
						translationTarget[i] = Character.toUpperCase(translationTarget[i]);
					}
					translated[i-numCon] = translationTarget[i];
				}
				
				translated = Arrays.copyOf(translated, translationTarget.length+2);
				int conPrint = 0;
				for(int i = initialSize-numCon; conPrint < numCon; i++)
				{
					translated[i] = consonants[conPrint];
					conPrint++;
				}

				if(translated.length>0) 
				{
					translated[translated.length-2] = 'a';
					translated[translated.length-1] = 'y';
				}
			}
		}
	
		// Returns the original if translation is not warranted
		else
		{
			translated = Arrays.copyOf(translationTarget, translationTarget.length);
		}
		return translated;
	}

	private static boolean isVowel(char c, int p) {
		boolean result = false;
		c = Character.toLowerCase(c);	// Converts to lower case
		if(c =='a' || c=='e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
			result = true;
		if(p == 0 && c == 'y')
			result = false;
		return result;
	}
}