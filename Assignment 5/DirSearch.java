/* Name: Julian Sweatt
 * Class: COP3252
 * Instructor: Robert Myers
 * Due Date: March 8, 2018
 * Title: Assignment 5
 * Description: File System Printer/Sorter
 * */

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class DirSearch
{
	public static void main(String[] args)
	{
		String directory = ".";
		File dir;
		File interior; 
		File [] content; 
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd hh:mm:ss");
		char sortType = '\0';
		boolean validArgs = true;

		if(args.length == 0)			// Default Case
		{
		}
		else if(args.length!=0)
		{
			for(int i = 0; i < args.length; i++)
			{
				if(args[i].charAt(0)== '-')			// Handle flags "-"
				{
					if(sortType != '\0' || (args[i].length()!=2))
					{
						validArgs = false;
					}
					sortType = args[i].charAt(1);
					if(sortType != 'a' && sortType != 's' && sortType != 'l')
					{
						validArgs = false;
					}
				}
				if(args[i].charAt(0)!= '-')
				{
					//String absolute = "~/" + args[i];
					dir = new File(args[i]);
					if(dir.isDirectory())
					{
						directory = args[i];
					}
					else
					{
						System.out.println("Invalid Directory Name.");
						validArgs = false;
					}
				}
			}
		}
		
		if(validArgs)
		{
			dir = new File(directory);
			if(dir.list() == null)
			{
				System.out.println("The specified directory is empty.");
			}
			content = dir.listFiles();
			Sort(content, sortType);
			
			for(int i = 0; i < content.length; i++)
			{
				interior = content[i];
				System.out.printf("%8d",interior.length());
				System.out.print("  ");
				System.out.printf("%s",formatter.format(interior.lastModified()));
				System.out.print("  ");
				System.out.print(interior.getName());
				System.out.println();
			}
		}
		else
		{
			System.out.println("usage:  java -jar hw5.jar [directory] [-a | -l | -s]");
			System.out.println("        (current directory is default)");
			System.out.println("        -a alphabetical sorting");
			System.out.println("        -l last time modified sorting");
		}
	}
	
	public static void Sort(File [] content, char sortType)
	{
		//File interior; 
		//File interior2;
		
		if(sortType == 'a')
		{
			Arrays.sort(content);
		}
		else if(sortType == 's')
		{
			Arrays.sort(content, new SizeSort());
		}
		else if(sortType == 'l')
		{
			Arrays.sort(content, new DateSort());
		}

	}

}