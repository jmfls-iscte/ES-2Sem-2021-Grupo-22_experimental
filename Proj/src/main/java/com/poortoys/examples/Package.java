package com.poortoys.examples;

import java.util.ArrayList;
import java.util.List;

public class Package {
	
	private String name;
	private ArrayList<Class> arrayClasses;
	
	public Package()
	{
		arrayClasses = new ArrayList<Class>();
	}
	
	public Package(String name)
	{
		this.name = name;
		arrayClasses = new ArrayList<Class>();
	}
	
	public String getName_Package() {
		return "";
	}
	
	public List<Class> getClass_list(){
		return arrayClasses;
	}
	
	public void setName_Package(String name)
	{
		this.name=name;
	}
	
	public void addClass(Class classToAdd)
	{
		if(!verifyExistsClass(classToAdd))
			arrayClasses.add(classToAdd);
	}
	
	private boolean verifyExistsClass(Class classToVerify)
	{
		//TO DO
		return false;
	}

}
