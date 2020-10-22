package com.point;

import java.util.ArrayList;
import java.util.List;

public class Student {  
    private String name;  
      
    public String getName() {  
        return name;  
    }  
      
    public void setName(String name) {  
        this.name = name;  
    }  
      
    public void displayInfo(){  
        System.out.println("Hello: "+name);  
    }
    
    public int maxEvents_orig(List<Integer> arrival,List<Integer> duration) {
        int counter = 0;
        arrival.add(Integer.MAX_VALUE);duration.add(0);
        for (int i = 0; i < arrival.size()-1; i++) {
        	System.out.println("i: "+i+", arrival:"+arrival.get(i)+", duration:"+duration.get(i)+", next arrival(i+i):"+arrival.get(i+1));  
            if (arrival.get(i) + duration.get(i) <= arrival.get(i+1)) {            	
                counter++;
                System.out.println("case 1, increased counter:"+counter);
            } else if (arrival.get(i)==arrival.get(i+1)) {
                counter++;
                i++;
                System.out.println("case 2, arr(i)=arr(i+1), increased counter:"+counter+", and i:"+i);
            } else if (i == arrival.size()-1) {
                counter++;
                System.out.println("case 3,i == arrival.size()-1, increased counter:"+counter);
            }
        }
        return counter;
    }
    public int maxEvents(List<Integer> arrival,List<Integer> duration) {
        int counter = 0;
        for (int i = 0; i < arrival.size(); i++) {
        	System.out.println("i: "+i+", arrival:"+arrival.get(i)+", duration:"+duration.get(i));
        	// looking the overlap with rest events
        	for (int j = 0; j < arrival.size(); j++) {
        		if (j==i)
        			continue;
	            if (arrival.get(i) <= arrival.get(j) && (arrival.get(i)+duration.get(i))>arrival.get(j)) {
	                // skip it 
	                System.out.println("skip event:"+i+", or event j (as it overlapped):"+j+" arr/dur:"+arrival.get(j)+","+duration.get(j));
	                // --> need to delete it, i or j, which has the longer length
	                if ( duration.get(i) >= duration.get(j) ) {
	                	// delete i
	                	System.out.println("delete event:"+i);
	                	arrival.remove(i); duration.remove(i);
	                } else {
	                	// delete j
	                	System.out.println("delete event:"+j);
	                	arrival.remove(j); duration.remove(j);
	                }
	                i--; // need go back by one
	                break;
	            } 
        	}      	
        }
        for (int i = 0; i < arrival.size(); i++) {
        	System.out.println("i: "+i+", kept arrival:"+arrival.get(i)+", kept duration:"+duration.get(i));
        }
        counter = arrival.size();
        return counter;
    }
 }  