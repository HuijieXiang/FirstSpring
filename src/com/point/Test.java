package com.point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test implements Runnable, Sayable{
	//public class Test extends Thread{
	static Test singletonTest=null;
	private Test() {
		System.out.println("in private Test constructor");
	}
	static public Test getTest() {
		if (singletonTest==null) {
			singletonTest = new Test();
			System.out.println(" init singletonTest");
		} else {
			System.out.println(" return the existing singletonTest");
		}
		return singletonTest;
	}
	
	static String xy;
	public void run() {
		System.out.println("running :+currentThread():"+Thread.currentThread());
	}
	//@Override
	public void sayMore(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);  
	}
	//@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("override say default method!!");  
	} 
    protected void finalize()   
    {   
        System.out.println("finalize method called from Test class finalize method()");   
    } 	
	public static void main(String[] args) throws Exception {  
		System.out.println("args len:"+args.length);
		
		System.out.println("args len:"+args.length+" int xy:"+xy);
	    Resource resource=new ClassPathResource("applicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(resource);  
	      
	    Student student=(Student)factory.getBean("studentbean");  
	    student.displayInfo(); 
	    
	    List<Integer> arr= new ArrayList<Integer>();
		List<Integer> dur = new ArrayList<Integer>();
		arr.add(1);arr.add(3);arr.add(5);arr.add(7);		
		dur.add(2);dur.add(2);dur.add(1);dur.add(2);
		
//		arr.add(1);arr.add(3);arr.add(4);arr.add(7);		
//		dur.add(2);dur.add(2);dur.add(3);dur.add(2);
		
//		arr.add(1);arr.add(1);arr.add(1);arr.add(4);		
//		dur.add(3);dur.add(2);dur.add(1);dur.add(2);
//		arr.add(250);arr.add(74);arr.add(659);arr.add(931);arr.add(273);arr.add(545);arr.add(897);
//		dur.add(924);dur.add(710);dur.add(441);dur.add(166);dur.add(493);dur.add(43);dur.add(988); 
//		System.out.println("arrival size: "+arr.size()+" duration size:"+dur.size());
//		int cnt = student.maxEvents(arr, dur);
//		System.out.println("maxEvents cnt: "+cnt);
	    
        //Resource r=new ClassPathResource("applicationContext.xml");  
        factory=new XmlBeanFactory(resource);            
        Employee s=(Employee)factory.getBean("employeebean");        
        s.show();  	    
        
//        ExpressionParser parser = new SpelExpressionParser();  
//        
//        Expression exp = parser.parseExpression("'Hello my World'.bytes");  // 'Welcome SPEL'.concat('!')  'Hello SPEL'  'Hello World'.bytes
//        //String message = (String) exp.getValue();  
//        //System.out.println(message); 
//
//        byte[] bytes = (byte[]) exp.getValue();  
//        for(int i=0;i<bytes.length;i++){  
//            System.out.print(bytes[i]+" "); 
//        }
        
        int number=651156; // 651056; not reversed number
        // option 2: number-> StringBuffer, reverse the string, if the reversed string number ==original number, it is reversed number.
        String tmp = Integer.toString(number);
        int len=tmp.length();
        System.out.println(" number len:"+len+", len/2:"+len/2);
        boolean checkRev=true;
        for (int i=0; i<len/2; i++) {
        	if (tmp.charAt(i)!=tmp.charAt(len - i - 1)) {
        		System.out.println(" number not reversed at:"+tmp.charAt(i) +", and:"+tmp.charAt(len-i-1));
        		checkRev = false;
        		break;
        	}
        }
        if (checkRev)
        	System.out.println(number  +": The number IS reversed");
        else 
        	System.out.println(number  +": The number is NOT reversed");
        
       Test test = new Test();
       Thread thread = new Thread(test);
       thread.start();
       
       Random random = new Random();
       //random.ints().limit(10).forEach(System.out::println);
       
       List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

     //get list of unique squares
       List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
       squaresList.forEach(System.out::println);
       
       List<String> names =Arrays.asList("this", "that", "his");
      // Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
       Collections.sort(names);
       //names.forEach(System.out::println);
       
       List<Product> productsList = new ArrayList<Product>();  
       //Adding Products  
       productsList.add(new Product(1,"HP Laptop",25000f));  
       productsList.add(new Product(2,"Dell Laptop",30000f));  
       productsList.add(new Product(3,"Lenevo Laptop",28000f));  
       productsList.add(new Product(4,"Sony Laptop",28000f));  
       productsList.add(new Product(5,"Apple Laptop",90000f));  
       productsList.stream().filter(prod -> prod.price >= 30000).forEach(prod->System.out.println("Id:"+prod.id+", name: "+prod.name+",price:"+prod.price));
       List<Float> productPriceList2 =productsList.stream().filter(p -> p.price > 30000).map(p->p.price).collect(Collectors.toList()); // collecting as list  
       //System.out.println(productPriceList2);  
       
       // Using Collectors's method to sum the prices.  
       double totalPrice3 = productsList.stream().collect(Collectors.summingDouble(pr->pr.price));  
       System.out.println(totalPrice3);
       
       test.say2();   // calling default method  
       test.say();
       test.sayMore("Work is worship");  // calling abstract method
       
//       String[] str = new String[10];  
//       String lowercaseString = str[5].toLowerCase();  
//       System.out.print(lowercaseString); 
       Map <Integer, String> map=new HashMap<Integer, String>();  
       //Adding elements to map  
       map.put(1,"Amit");  
       map.put(5,"Rahul");  
       map.put(2,"Jai");  
       map.put(6,"Amit");  
       //Traversing Map  
       Set set=map.entrySet();//Converting to Set so that we can traverse  
       Iterator itr=set.iterator();  
//       while(itr.hasNext()){  
//           //Converting to Map.Entry so that we can get key and value separately  
//           Map.Entry entry=(Map.Entry)itr.next();  
//           System.out.println("Key:"+entry.getKey()+", value: "+entry.getValue());  
//       }
//       for(Map.Entry<Integer, String> m:map.entrySet()){
//    	   System.out.println(m.getKey()+" "+m.getValue());  
//    	  } 
       String s2=50+30+"Sachin"+40+40;  
       System.out.println(s2);//80Sachin4040  
       String [] sa = {"cat","dog","fish"};
       String c2="cat"; boolean cat2=(sa[0]==c2);
       System.out.println("Testing out sa[0]==c2 :"+cat2); 

//       GetPlanFactory planFactory = new GetPlanFactory();  
//       System.out.print("Enter the name of plan for which the bill will be generated: ");  
//       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
//       // DOMESTICPLAN 	COMMERCIALPLAN
//       String planName=br.readLine();  
//       System.out.print("Enter the number of units for bill will be calculated: ");  
//       int units=Integer.parseInt(br.readLine());  
//       Plan p = planFactory.getPlan(planName);  
//       //call getRate() method and calculateBill()method of DomesticPaln.  
//       System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");  
//            p.getRate();  
//            p.calculateBill(units);  
	
	
	   CDBuilder cdBuilder=new CDBuilder();  	   
	   //cdType1.getCost();
	   Packing packs1 = new Sony();
	   System.out.println("sony1 price:"+packs1.price());
	   CDType cdType1 = cdBuilder.buildSonyCD();
	   cdType1.addItem(packs1);
	   cdType1.showItems();	  
	   CDType cdType2=cdBuilder.buildSamsungCD();  
	   cdType2.showItems();
	   
       System.out.println("Observer pattern or publish-subscribe Enter Text >");
//       // create an event source - reads from stdin
//       final EventSource eventSource = new EventSource();
//       // create first observer
//       final ResponseHandler1 responseHandler1 = new ResponseHandler1();
//       // subscribe the observer to the event source
//       eventSource.addObserver(responseHandler1);
//       // create second observer
//       final ResponseHandler2 responseHandler2 = new ResponseHandler2();
//       // subscribe the observer to the event source
//       eventSource.addObserver(responseHandler2);
//       // starts the event thread
//       Thread thread2 = new Thread(eventSource);
//       thread2.start();
	   
       String str = "two"; 
       switch(str) 
       { 
           case "one": 
               System.out.println("one"); 
               break; 
           case "two": 
               System.out.println("two"); 
               break; 
           case "three": 
               System.out.println("three"); 
               break; 
           default: 
               System.out.println("no match"); 
       } 
       Object x = new Object();
       String y="mystr";
       //y = (String)x; // runtime error : java.lang.Object cannot be cast to java.lang.String
       //x = y; ok
       //System.out.println("object x:"+x+", string y:"+y);

       try {
    	   throw new myException();
       } catch (myException my) {
    	   System.out.println("My exception here:"+my.getMessage());
       } catch (Exception ex) {
    	   System.out.println("Exception here:"+ex.getMessage());
       }
       
       test = null;
       System.gc();
       System.out.println("end of garbage collection"); 
   }        
		
}
