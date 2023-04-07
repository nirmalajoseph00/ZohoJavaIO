package com.zohocorp.zohojavaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BufferedOutputStreamEg {

	public static void main(String[] args) 
	{
		//FileOutputStream
		//BufferedOutputStream
		try {
			FileOutputStream fout=new FileOutputStream("trial.txt");
			BufferedOutputStream bout=new BufferedOutputStream(fout);
			String s="Nirmala Joseph";    
		     byte b[]=s.getBytes();    
		     bout.write(b);  //bytes wrote to bout which   
		     bout.flush();    
		     bout.close(); 
		     fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try{    
		    FileInputStream fin=new FileInputStream("trial.txt"); //store file in same pjt as code   
		    BufferedInputStream bin=new BufferedInputStream(fin);    
		    int i;    
		    System.out.println("Data  from trial file: ");
		    while((i=bin.read())!=-1)
		    {    
		    	System.out.print((char)i);    
		    }    
		    System.out.println();
		    bin.close();    
		    fin.close();    
		  }
		catch(Exception e)
		{
			  System.out.println(e);
		}  
		
		//FileWriter
		//PrintWriter
		//PrintWriter object wraps around the FileWriter object
		//PrintWriter object helps us write to a file the same way we write to a screen
		
		ArrayList<String> items = new ArrayList<String>();
		items.add("Bread");
		items.add("Milk");
		items.add("Pasta");
		items.add("Butter");
		try
		{
			FileWriter fw = new FileWriter("trial2.txt"); // overwrite the file each time
			//FileWriter fw = new FileWriter("trial2.txt",true); //true=>instead of overwriting it will append info to the file
			
			PrintWriter pw = new PrintWriter (fw);//pw prints each item in its own line
			for(int i = 0; i < items.size(); i++)
				pw.println(items.get(i));
			pw.close(); //manage resources correctly
			//could corrupt file if we don't close
			//close file handles so they can be used by other prgms in the OS
			// This is especially true when writing a file as the operating system with deny other programs access until the file is closed.
			fw.close();
		}
		catch (IOException e) 
		{
			System.out.println(e);
		}
		
		//read & store to arraylist => don't know no. of lines beforehand so can't use array
		try 
		{
			ArrayList<String> data = new ArrayList<String>();
					
			FileReader fr = new FileReader("trial2.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null)
					data.add(line);
			br.close();
			System.out.println("Data read from trial2 file: "+ data);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		//read using Scanner class
		try
		{
			File file=new File("trial2.txt");
			Scanner reader=new Scanner(file);
			System.out.println("Data read from trial2 file using scanner");
			while(reader.hasNext())
			{
				System.out.println(reader.nextLine());
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
