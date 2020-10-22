package com.point;

public class Sony extends Company {
	public Sony () {
		super();
	}
	
    @Override  
    public int price(){ 
    	
        return 20;  
    }
    
	@Override  
	public String pack(){  
	         return "Sony CD";  
    } 
}
