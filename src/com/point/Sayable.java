package com.point;

public interface Sayable {
    // Default method   
    default void say(){  
        System.out.println("Hello, this is default method");  
    } 
    // default method 2
    default void say2(){  
        System.out.println("Hello, this is 2nd default method");  
    }  
    // Abstract method  
    void sayMore(String msg);  
}
