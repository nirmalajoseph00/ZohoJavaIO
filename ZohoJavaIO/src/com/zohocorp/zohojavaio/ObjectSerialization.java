package com.zohocorp.zohojavaio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSerialization 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File file = new File ("students.txt");
		ArrayList<Student> students = new ArrayList<Student> ();
		students.add(new Student("Tom", 14));
		students.add (new Student("Dave", 14));
		students.add(new Student("Bill", 13));
		
		//serialize the collection of students.
		FileOutputStream fo = new FileOutputStream (file); //Used to write to a file, treating it as bytes instead of text
		ObjectOutputStream output = new ObjectOutputStream (fo); //Used to serialize a data input stream(object)
		for (Student s: students ) 
		{
			output.writeObject(s);
		} 
		output.close();
		fo.close();
		
		//deserialize the file back into collection
		FileInputStream fi=new FileInputStream(file);
		ObjectInputStream input=new ObjectInputStream(fi);
		List<Student> students2=new ArrayList<>();
		
		while(true) 
		{
			try 
			{
				Student s=(Student)input.readObject();//read object from file & cast it as Student type b4 storing to s
				students2.add(s);
			} 
			catch(EOFException ex)
			{}
		}
		
	}
		
	}
