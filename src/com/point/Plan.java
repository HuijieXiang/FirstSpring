package com.point;

abstract class Plan{  
    protected double rate;  
    abstract void getRate();  

    public void calculateBill(int units){  
         System.out.println("the bill: "+units*rate);  
     }  
}