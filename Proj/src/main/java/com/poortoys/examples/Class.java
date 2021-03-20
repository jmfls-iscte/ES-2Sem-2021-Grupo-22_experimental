package com.poortoys.examples;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Class {
	
	private String name;
	private ArrayList<Method> arrayMethods;
	private int NOM_class;
	private int LOC_class;
	private int WMC_class;
	boolean is_God_class;
	
	
	public Class()
	{
		arrayMethods = new ArrayList<Method>();
		//Adicionar as métricas já conhecidas
	}
	
	public Class(String name)
	{
		this.name = name;
		arrayMethods = new ArrayList<Method>();
		//Adicionar as métricas já conhecidas
	}
	
	public String getName_Class() {
		return name;
	}
	
	public List<Method> getMethod_list(){
		return arrayMethods;
	} 
	
	public Method get_MethodByName(String methodname)
	{
		for(Method m:arrayMethods)
		{
			if(m.getName_method()==methodname)
				return m;
		}
		
		return null;
	}
	
	
	public int getNOM_class() {
		return this.NOM_class;
	}
	
	public int getLOC_class() {
		return  this.LOC_class;
	}
	
	public int getWMC_class() {
		 return this.WMC_class;
	}
	
	public boolean getis_God_class() {
		return is_God_class;
	}
	
	
	public void set_Name(String name)
	{
		this.name = name;
	}
	
	public void addMethod(Method methodToAdd)
	{
		if(!verifyExistsMethod(methodToAdd))
			arrayMethods.add(methodToAdd);
	}
	
	private boolean verifyExistsMethod(Method methodToVerify)
	{
		//TO DO
		return false;
	}
	

	
	

}
