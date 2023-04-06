package Hack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Hacker 
{
	public void writeHistoryFile(ArrayList<String> browserUrl) 
	{
		try 
		{
			File file=new File("history.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw=new PrintWriter(fw);
			for(String element:browserUrl)
			{
				pw.println(element);
			}
			pw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	public void readHistoryFile() 
	{
		try 
		{
			BufferedReader reader=new BufferedReader(new FileReader("history.txt"));
			String line;
			while((line=reader.readLine())!=null)
			{
				System.out.println(line);
			}
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	 

}
