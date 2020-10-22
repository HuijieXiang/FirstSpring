package com.myapp;

public class Product {  //implements Comparable<Product>
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }
//	@Override
//	public int compareTo(Product o) {
//		//return this.name.compareTo(((Product)o).name);
//		//return (int)(this.price - ((Product)o).price);  //Ascending on price
//		return (int)(o.price - this.price);  //Descending on price
//	}
}  