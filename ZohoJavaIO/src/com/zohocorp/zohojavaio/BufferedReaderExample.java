package com.zohocorp.zohojavaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BufferedReaderExample {

	public static void main(String[] args) 
	{
		List<String> names=new LinkedList<>();
		names.add("Roy");
		names.add("Neena");
		names.add("Alfred");
		try 
		{
			BufferedWriter writer=new BufferedWriter(new FileWriter("trial.txt")); //Buffered Writer can write into different things so we ve to specify v r writing to a file
			writer.write("Names");
			for(String element:names)
			{
				writer.write("\n"+element);
			}
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			BufferedReader reader=new BufferedReader(new FileReader("trial.txt"));
			String line;
			while((line=reader.readLine())!=null)
				System.out.println(line);
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
