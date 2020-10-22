package com.pattern;

public class FileFactory {
	public File createFile(String name, String cata, Metadata meta ) {
		switch (cata) {
		case "text":
			return new TextFile(name,cata, meta);
		case "binary":
			return new BinaryFile(name,cata, meta);
		case "image":
			return new ImageFile(name,cata, meta);
		default: 
				System.out.println("invalid category:"+cata);				
		};
		
		return null;
	}
}
