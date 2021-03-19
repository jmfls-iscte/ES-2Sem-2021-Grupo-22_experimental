package com.poortoys.examples;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Class {
	
	private String name;
	private ArrayList<Method> arrayMethods;
	private HashMap<String, Integer> hashMetricas;
	boolean is_God_class;
	
	
	public Class()
	{
		arrayMethods = new ArrayList<Method>();
		hashMetricas = new HashMap<String, Integer>();
		//Adicionar as métricas já conhecidas
	}
	
	public Class(String name)
	{
		this.name = name;
		arrayMethods = new ArrayList<Method>();
		hashMetricas = new HashMap<String, Integer>();
		//Adicionar as métricas já conhecidas
	}
	
	public String getName_Class() {
		return name;
	}
	
	public List<Method> getMethod_list(){
		return arrayMethods;
	} 
	
	public int getNOM_class() {
		return hashMetricas.get("NOM_class");
	}
	
	public int getLOC_class() {
		return  hashMetricas.get("LOC_class");
	}
	
	public int getWMC_class() {
		 return hashMetricas.get("WMC_class");
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
	
	
	public void setMetrica(String name, int value)
	{
		if(!verifyExistsMetric(name))
		{
			addMetric(name, value);
		}
		else
		{
			hashMetricas.replace(name, value);
		}
	}
	
	private boolean verifyExistsMetric(String metricToVerify)
	{
		
		return hashMetricas.containsKey(metricToVerify);
	}
	
	public void addMetric(String name)
	{
		hashMetricas.put(name, 0);
	}
	
	public void addMetric(String name, int value)
	{
		hashMetricas.put(name, value);
	}

}
