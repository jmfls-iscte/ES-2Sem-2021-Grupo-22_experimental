package com.poortoys.examples;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

public class Package {
	
	private String name;
	private ArrayList<Class> arrayClasses;
	
	public Package(String name,File file) {
		this.name=name;
		System.out.println(name);
		arrayClasses = new ArrayList<Class>();
	
		List<File> files= Arrays.asList(file.listFiles()).stream().filter(x->FilenameUtils.getExtension(x.getAbsolutePath()).equals("java")).collect(Collectors.toList());
		for(File x: files) {
			//criar classe com file e adicionar a arrayclasses
		}
		
	}
	
	
	
	//
	
	public String getName_Package() {
		return name;
	}
	
	public List<Class> getClass_list(){
		return new ArrayList<Class>();
	}

}
