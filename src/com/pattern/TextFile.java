package com.pattern;

import java.util.List;
import java.util.Map;

public class TextFile extends File {

	public TextFile(String name, String cata, Metadata meta) {
		setCatagory(cata);
		setFileName(name);
		setMetadata(meta);
	}

	@Override
	List<File> listFile(String name, String cata, Metadata meta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	File searchFile(String fileName, Map<String, String> otherAttributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void modifyFile(File file, Map<String, String> updateKeyValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void printFile(File file) {
		System.out.println("Printing Text File Here !!");
		
	}

	@Override
	protected void setCatagory(String catagory) {
		super.catagory=catagory;
		
	}

}
