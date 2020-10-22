package com.pattern;

import java.util.List;
import java.util.Map;

abstract class File {
	private String fileName;
	protected String catagory; // text, binary, image, video, music, office
	private Metadata metadata;
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCatagory() {
		return catagory;
	}

	abstract void setCatagory(String catagory);

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	abstract List<File> listFile(String name, String cata, Metadata meta);
	
	abstract File searchFile(String fileName, Map<String, String> otherAttributes);
	
	abstract void modifyFile(File file, Map<String, String> updateKeyValue);
	
	abstract void printFile(File file);
}