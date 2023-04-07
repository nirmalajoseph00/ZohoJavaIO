package com.zohocorp.zohojavaio;

import java.io.Serializable;

public class Student implements Serializable //tells java we want to write Student object to a file & read from it
{
	private String name;
	private int age;
	
	public Student(String name,int age)
	{
		this.name=name;
		this.age=age;
		
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
}
