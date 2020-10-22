package com.myapp;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Panel;
import java.io.BufferedReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyHome {
	static int total=10;
	
	public MyHome() {
		System.out.println("Constructor of MyHome");
		System.out.println(this);
		int temp=this.total;
		if (temp>5) {
			System.out.println("temp:"+temp);
		}
	}
	public void mapExercise() {	
		//Document doc;
        Map<String, String> mapLang = new TreeMap<>();        
        mapLang.put(".c", "C");
        mapLang.put(".java", "Java");
        mapLang.put(".pl", "Perl");
        mapLang.put(".cs", "C#");
        mapLang.put(".php", "PHP");
        mapLang.put(".cpp", "C++");
        mapLang.put(".xml", "XML");      
        System.out.println(mapLang);
        
        Map<Integer, String> mapHttpErrors = new HashMap<>();
        mapHttpErrors.put(400, "Bad Request");
        mapHttpErrors.put(304, "Not Modified");
        mapHttpErrors.put(200, "OK");
        mapHttpErrors.put(301, "Moved Permanently");
        mapHttpErrors.put(500, "Internal Server Error");
        System.out.println(mapHttpErrors);
        String status301 = mapHttpErrors.get(301);
        System.out.println("301: " + status301);
        if (mapHttpErrors.containsKey(200)) {
            System.out.println("Http status 200");
        }
        if (mapHttpErrors.containsValue("OK")) {
            System.out.println("Found status OK");
        }        
        System.out.println(" mapHttpErrors size:"+mapHttpErrors.size());
        if (mapHttpErrors.isEmpty()) {
            System.out.println("No Error");
        } else {
            System.out.println("Have HTTP Errors");
        }
        for (Map.Entry<Integer, String> entry : mapHttpErrors.entrySet()) {
            int key = entry.getKey();
            String country = entry.getValue();
            System.out.println(key + " => " + country);
        }
        System.out.println("java 8 map entry set:");
        mapHttpErrors.forEach( (k,v) -> System.out.println( k + "=>" + v ) );
        
//        try {
//        	//int a=10/0;
//        	int [] arr= {3,5};
//        	arr[4]=5;
//        } catch (ArithmeticException | NullPointerException |ArrayIndexOutOfBoundsException ex) {
//        	System.out.println(ex);
//        	//e=null;
//        	//System.out.println("one more:"+e);
//        }
        
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        // IntStream mapToInt(), and mapToLong, mapToDouble
//        System.out.println("Highest number in List : " + stats.getMax()); //stats.andThen(after)
//        System.out.println("Lowest number in List : " + stats.getMin());
//        System.out.println("Sum of all numbers : " + stats.getSum());
//        System.out.println("Average of all numbers : " + stats.getAverage());
        System.out.println("all data: " + stats);
        numbers.forEach((i)->System.out.print(" "+i));
        
        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> squared = e -> e * e;
        System.out.println("compose:"+times2.compose(squared).apply(4)); 
        System.out.println("andThen:"+times2.andThen(squared).apply(4)); 
	}
	public ArrayList<ArrayList<Integer>> findTuples(ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Integer> z) {
		ArrayList<ArrayList<Integer>> tuples = new ArrayList<ArrayList<Integer>>();
		if (x==null ||x.size()==0) {
			// return empty result if input is empty
			return tuples;
		}
		for (int i=0; i<z.size(); i++) {
			//System.out.println("z "+i+":"+z.get(i));
			for (int j=0; j<y.size(); j++) {
				//System.out.println("  y "+j+":"+y.get(j));
				for (int k=0; k<x.size(); k++) {
					if (z.get(i)-y.get(j)==x.get(k)) {
						//System.out.println("  found x, y, z "+x.get(k)+":"+y.get(j)+":"+z.get(i));
						ArrayList<Integer> elem = new ArrayList<Integer>();
						elem.add(x.get(k));
						elem.add(y.get(j));
						elem.add(z.get(i));
						tuples.add(elem); // missed
					}
				}
			}
		}
		return tuples;
	}
    /*
     * Complete the 'getMinimumUniqueSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public int getMinimumUniqueSum(List<Integer> arr) {
    // Write your code here
    int minsum=0;
    boolean hasDiff=true;
    while (hasDiff) {
    	System.out.println("loop on arr size:"+arr.size());
		hasDiff= false;
    	for (int i=0;i<arr.size(); i++) {
    		for (int j=i+1;j<arr.size(); j++) {
	    		if( arr.get(i) == arr.get(j) ) {
		            //increase the element J
		            arr.set(j, arr.get(j)+1);
		            hasDiff = true;
		            System.out.println("set hasDiff=true");
		            break;
	            } 
    		}
        }
    }	
    	// get result sum
    	for(int i:arr) {
    		minsum=minsum+i;
    	}
    	return minsum;
	}
    
    // get Max subsequence with threshold. eg (4,8,8,3,1) threshold=15, return: (4,8,3)
    public List<Integer> maxSubsequence(List<Integer> seq, int threshold) {
    	boolean loop=true;    	
    	int lastmax = 0;
    	System.out.println("threshold:"+threshold);
//    	System.out.println("input seq:");
//    	seq.forEach(System.out::println);
    	
    	List<Integer> lastmaxsub = new ArrayList<Integer>();
    	int ind=0;
    	while (loop && ind<seq.size()) {
    		List<Integer> curmaxsub = new ArrayList<Integer>();
    		int curmax = 0;
	    	for (int i=ind; i<seq.size(); i++) {
	    		if (curmax==threshold) {
	    			System.out.println("done, curmax==threshold:"+curmax+ " "+threshold);
	    			loop = false;
	    			break;
	    		}
	    		System.out.println(" curmax:"+curmax+ ", seq.get(i): "+seq.get(i));
	    		if (curmax+seq.get(i)<=threshold) {
	    			curmaxsub.add(seq.get(i));
	    			curmax = curmax+seq.get(i);
	    			System.out.println("increase curmax:"+curmax+", curmaxsub size:"+curmaxsub.size());
	    			if (curmax==threshold) {
		    			System.out.println("done 2, curmax==threshold:"+curmax+ " "+threshold);
		    			loop = false;
		    			break;
		    		}
	    		}
	    	}
	    	if(curmax>lastmax) {	    		
	    		lastmaxsub = curmaxsub; lastmax=curmax;
	    		System.out.println("assigned curmax to last");
	    	}
	    	ind++;
    	}
    	System.out.println("return  lastmaxsub");
    	return lastmaxsub;
    }
    
    // mini possible total distance crew traveled to job site 
    public int minCost(List<Integer> crew, List<Integer> job) {
    	int minc=0;
    	Collections.sort(crew);
    	Collections.sort(job);
    	System.out.println("crew and job after sorted");
    	System.out.println(crew);
    	System.out.println(job);
    	for (int i=0; i<crew.size(); i++) {
    		int loopmin=Integer.MAX_VALUE;
    		int loopPos=0;
    		for (int j=0; j<job.size(); j++) {
    			if (Math.abs(job.get(j)-crew.get(i))<loopmin) {
    				loopmin = Math.abs(job.get(j)-crew.get(i));
    				loopPos=j;
    			}
    		}
    		System.out.println("crew("+i+")="+crew.get(i)+", loopmin:"+loopmin+", remove job at loopPos:"+loopPos);
    		job.remove(loopPos);
    		minc+=loopmin;
    	}
    	return minc;
    }
    
    // longest sub array contains no more than 2 distinct numbers, with differ <=1
    public int longSubarray(List<Integer> arr) {
    	int maxsub=0;
    	if (arr.size()==0) return maxsub;
    	maxsub++;
    	if (arr.size()==1) return maxsub;
    	System.out.println(arr);
    	int ind=0; int lpsub=0; int lpprev; boolean progress=false;
    	while ( ind<arr.size()) {  
    		lpsub=0; lpprev=arr.get(ind);  progress=false;
    		System.out.println("start ind:"+ind+", value:"+lpprev);
    		for (int i=ind; i<arr.size(); i++) {
    			if(Math.abs(arr.get(i)-lpprev)<=1) {
    				lpsub++;
    			} else {
    				ind=i; progress=true;
    				System.out.println(" set new ind:"+ind+", i:"+i+", loop prev:"+lpprev+",lpsub:"+lpsub);
    				break;
    			}
    		}
    		if (lpsub>maxsub) {
    			maxsub = lpsub;
    			System.out.println("save the loop sub:"+maxsub);
    		}
    		if (!progress)
    			ind++;
    	}
    	return maxsub;
    }
    
    /*
     Complete the hourglassSum function below.
    1 1 1 0 0 0
	0 1 0 0 0 0
	1 1 1 0 0 0
	0 0 2 4 4 0
	0 0 0 2 0 0
	0 0 1 2 4 0
	expected: 19
	
	-9 -9 -9 1 1 1
	0 -9 0 4 3 2
	-9 -9 -9 1 2 3
	0 0 8 6 6 0
	0 0 0 -2 0 0
	0 0 1 2 4 0
	
	-1 -1 0 -9 -2 -2
	-2 -1 -6 -8 -2 -5
	-1 -1 -1 -2 -3 -4
	-1 -9 -2 -4 -4 -5
	-7 -3 -3 -2 -9 -9
	-1 -3 -1 -2 -4 -5
	expected:-6
     */
    public int hourglassSum(int[][] arr) {
        int msum=0; //int msum=Integer.MIN_VALUE;
        int len=arr[0].length;
        for (int i=0; i<len-2; i++) {            
            for (int j=0; j<len-2; j++) {
                int cursum=0;
                cursum+=arr[i][j];
                cursum+=arr[i][j+1];
                cursum+=arr[i][j+2];
                cursum+=arr[i+1][j+1];
                cursum+=arr[i+2][j];
                cursum+=arr[i+2][j+1];
                cursum+=arr[i+2][j+2];
                if (cursum>msum) {
                    msum=cursum;
                }
            }
        }

        return msum;

    }
    /* move list left by d
		arr = 1 2 3 4 5
		d = 4
		expected: 5 1 2 3 4
     */
    public int[] rotLeft(int[] a, int d) {
        int tmp=a[0];
        int len=a.length;
        int ind=0;
        while (ind<d) {
	        // move left by one
	        tmp=a[0];
	        for (int i=0; i<len-1; i++) {
	            a[i]=a[i+1];
	        }
	        a[len-1]=tmp;
	        ind++;
        }
        return a;
    }
    
    /* out the large frequent sequence in beginning 
     input :size=19
     	arr={1,2,2,3,3,3,4,4,5,5,5,5,6,6,6,7,8,9,10};
     expected output:[5,5,5,5,3,3,3,6,6,6,2,2,4,4,1,7,8,9,10] 
     */
    public List<Integer>  freqOrder(int [] arr, int size) {
    	List<Integer> res = new ArrayList<Integer>();
    	// convert arry to listarray
    	List<Integer> inarr = new ArrayList<Integer>();
    	for (int i:arr) {
    		inarr.add(i);
    	}
    	Collections.sort(inarr); // sort it
    	System.out.println(inarr);
    	
    	//repeat the procedure till the end
    	while (inarr.size()>0) {
    		System.out.println("looping on input array === size:"+inarr.size());
    	//find longest occurrence and record it
    	int maxval=inarr.get(0);
    	int val=inarr.get(0); int count=1; int tmpcnt=0;
    	for (int i=0; i<inarr.size();i++) {
    		if (inarr.get(i)==val) {
    			tmpcnt++;
    		} else {
    			if (tmpcnt>count) {
    				count=tmpcnt;
    				maxval = val; 
    			}
    			tmpcnt=1; val=inarr.get(i);
    		}
    	}
    	//System.out.println(" max val:"+maxval+", count:"+count);
    	// move maxval with count to result list
    	for (int i=0; i<inarr.size();i++) {
    		if (inarr.get(i)==maxval) {
    			res.add(maxval);
    			inarr.remove(i);
    			i--;
    		}
    	}
    	//System.out.print("input array:");System.out.println(inarr);
    	//System.out.print("result array:");System.out.println(res);
    	}
    	System.out.print("result array:");System.out.println(res);
    	//Object [] tarr = res.toArray();
    	Integer [] t2 = (Integer [])res.toArray();
    	System.out.print("t2 array:");System.out.println(t2);
    	return res;
    }
    
    /* 012 0123
     * 210 3210 shift each char by 2,1,0 and 3,2,1,0
     * yum deed ==> avm ggfd 
     */
    public String encyptCycle(String st) {
    	String ret="";
    	StringTokenizer so =new StringTokenizer(st, " ");
    	while (so.hasMoreElements()) {
    		String onew=(String)so.nextElement();
    		int wlen = onew.length();
    		System.out.println("one word:"+onew+", word len:"+wlen);
    		StringBuffer addw=new StringBuffer();
    		for (int i=0; i<onew.length(); i++) {
    			// add/shift wlen-i, append to addw
    			int tn = onew.charAt(i);
    			//System.out.println("the letter at i:"+i+" ="+tn+", char:"+(char)tn);
    			tn=tn+wlen-i-1;
    			if (tn>=97+26) {
    				//System.out.println("the letter >= 123, then -26:"+tn);
    				tn=tn-26;
    			}
    			addw.append((char)tn);
    		}
    		addw.append(" ");
    		//System.out.println("the converted word:"+addw.toString());
    		ret+=addw.toString();
    	}
    	//System.out.println("the return string:["+ret+"], size:"+ret.length());
    	ret = ret.trim();    	
    	return ret;    	
    }
    /*
     * Amazon code challenge, find largest all one square size
        /*
         return =2
        		{1,1,1,1,1},
        		{1,1,1,1,1},
        		{1,1,0,1,1},
        		{1,1,1,1,1},
        		{1,1,1,1,1}         
         return =5
         		{1,1,1,1,1},
        		{1,1,1,1,1},
        		{1,1,1,1,1},
        		{1,1,1,1,1},
        		{1,1,1,1,1}
         return=4
                {0,1,0,1,0},
        		{0,1,1,1,1},
        		{0,1,1,1,1},
        		{0,1,1,1,1},
        		{0,1,1,1,1}
         return=3
                {0,1,0,1,0},
        		{0,1,1,1,0},
        		{0,1,1,1,0},
        		{0,1,1,1,0},
        		{0,1,0,1,0}
        return=2
                {0,1,1,0,0},
        		{0,1,1,1,0},
        		{0,0,1,1,0},
        		{0,1,1,1,0},
        		{0,1,1,1,0}        
        return=1	
                {0,1,0,1,0},
        		{0,1,1,1,0},
        		{0,1,0,1,0},
        		{0,1,1,1,0},
        		{0,1,0,1,0}
        */     
    public int maxAllOneSize(ArrayList<ArrayList<Integer>> prod) {
    	int maxsize=0;
    	int prodsize=prod.size();
    	for (int i=0; i<prodsize; i++) {
    		for (int j=0; j<prodsize; j++) {
    			//loop for every point in the two dimension array, find the largest size of all "one" square.
    			int k=0;
    			int kloopTime=i;
    			if (j>i) kloopTime=j;
    			System.out.println("i:"+i+",j:"+j+"; loop on kloopTime:"+kloopTime+", (i,j) value:"+prod.get(i).get(j));
    			int tmpmax=0;
    			while (k<prodsize-kloopTime) {
	    			boolean allOne=true;					// 			|
	    			// need k1, k2 loop, go through like this:			|
	    													//	________|
	    			for (int k1=0;k1<=k; k1++) {
					if (prod.get(i+k).get(j+k1)==0) {
						System.out.println("don't continue i+k:"+i+k+",j+k1:"+j+k1+", value:"+prod.get(i+k).get(j+k1));
						allOne = false;						
					}
	    			}
    				if (allOne) {
    					for (int k2=0;k2<=k; k2++) {
    					if (prod.get(i+k2).get(j+k)==0) {
    						System.out.println("don't continue i+k2:"+i+k2+", j+k:"+j+k+", value:"+prod.get(i+k2).get(j+k));
    						allOne = false;
    					}
    					}
    				}	    			
	    			System.out.println("k:"+k+" loop allOne :"+ allOne+", tmpmax:"+tmpmax);
	    			if (allOne) {
						tmpmax++;
						if (tmpmax>maxsize) {
							System.out.println("allOne switch max size to tmpmax:"+tmpmax);
							maxsize= tmpmax;
						}
					} else {
						if (tmpmax>maxsize) {
							System.out.println("switch max size to tmpmax:"+tmpmax);
							maxsize= tmpmax;
						}
						break;
					}
	    			k++;
    			}
    		}
    	}
    	System.out.println("final return:"+maxsize);
    	return maxsize;
    }
    
    public boolean isPrime(long num) {
    	for (long t=2;t<num; t++) {
    		if (num%t == 0) {
    			System.out.println("divided by:"+t);
    			return false;
    		}
    	}
    	return true;
    }
    
    /*
     * Given a list of numbers - sort them based on their frequency. Eg
     * input arr = {9, 2, 4, 5, 9, 4, 4 }
     * output {4, 4, 4, 9, 9, 2, 5 }
     * Keep the original sequence for the same element
     */
    public List<Integer> longSubArr(int[] arr) {
    	System.out.println(" find longSubArr" );
    	System.out.println(Arrays.toString(arr));
    	List<Integer> target = new ArrayList<Integer>();
    	LinkedHashMap<Integer,Integer> mp = new LinkedHashMap<Integer,Integer>();
        
        // add the key count into a linked map with count Descend order 
        for (int n:arr) {
        	if (mp.containsKey(n)) {
              Integer tmp = mp.get(n);
              tmp++;
              mp.put(n, tmp);
            } else {
            	mp.put (n, 1);
            }
        }
        System.out.println("origina mp:"+mp);

        // create LinkedHashMap with order by mp values
        //List<Map.Entry<Integer, Integer>> entlist = new ArrayList<Map.Entry<Integer, Integer>>(mp.entrySet());
        List<Entry<Integer, Integer>> entlist = new ArrayList<>(mp.entrySet());
        entlist.sort(Entry.comparingByValue());
        System.out.println(" map entlist:"+entlist);
        
        // from original mp to get target key values array, which has max value as 1st element, and so on. Also, keep the original sequence
        List<Integer> targetkey = new ArrayList<Integer>();
        boolean complete=false;
        while (!complete) {
        	int maxval=0, maxkey=0;
        	//mp.forEach( (k,v) -> System.out.println( k + "=>" + v ) );
        	for(Map.Entry<Integer, Integer> ent:mp.entrySet()) {
        		if (ent.getValue()>maxval) {
        			maxval = ent.getValue();
        			maxkey = ent.getKey();
        		}
        	}
        	//System.out.println(" maxkey"+maxkey + ", its value:"+maxval+", mp.size():"+mp.size());
        	targetkey.add(maxkey);
        	//remove the entry from mp
        	mp.remove(maxkey);
        	if (mp.size()==0) {
        		complete=true;
        	}
        }
        System.out.println(" targetkey:"+targetkey);
        // add to target
        for (int i=0; i<targetkey.size(); i++) {
        	int key=targetkey.get(i);
        	for (int jv:arr) {
        		if (jv==key)
        			target.add(key);
        	}        
        }
        System.out.println(" target:"+target);
        return target;
    }
    
    //public int findDifference(int[] numbers){  //Object[] numbers, String typeOf
    public <E> double findDifference(E[] numbers){	
    	double maxnum=0;
    	double minnum=10000; //Integer.MAX_NUMBER
    	  for (E g:numbers){
    		double i=(double)g;
    	  	if (i>maxnum) {
    	    	maxnum=i;
    	  	}
    	    if (i<minnum) {
    	    	minnum=i;
    	    }
    	  }
    	  return maxnum-minnum;
    }
    
    // generic method
    public <E> void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
           System.out.println(element);
        }
        System.out.println();
     }
    
    // count string permutations from HackerRank
    /*
     starting with a,e,i,o,u
     a only followed by e;
     e only followed by a or i;
     i only followed by a,e,o,u;
     o only followed by i or u;
     u only followed by a;
     testing result:
     Solution 1:
     n=2, cnt=10
     ENDING ...size:10
		[ae, ea, ia, oi, ua, ei, ie, io, iu, ou]
     n=3, cnt=19
     ENDING ...size:19
		[aea, eae, iae, oia, uae, eia, iea, ioi, iua, oua, eie, eio, eiu, iei, iou, aei, oie, oio, oiu]
     n=4, cnt=35
     ENDING ...size:35
[aeae, eaea, iaea, oiae, uaea, eiae, ieae, ioia, iuae, ouae, eiea, eioi, eiua, ieia, ioua, eiei, eiou, ieie, ieio, ieiu, aeia, oiea, oioi, oiua, ioie, ioio, ioiu, aeie, aeio, aeiu, oiei, oiou, eaei, iaei, uaei]
	 n=5, cnt=68
	 finally, modulo by (10^9  +7)
	 Allowed time limit:4 secs
	
	 Solution 2:
	n=1, size:5
	a, e, i, o, u; mp (a-1,e-1,i-1,o-1,u-1), value sum:5
	n=2, size:10
	[ae, ea, ia, oi, ua, ei, ie, io, iu, ou]
		mp (a(eiu)-3,e(ai)-2,i(eo)-2,o(i)-1,u(io)-2), value sum:10
	n=3, size: 19
	[aea, eae, iae, oia, uae, eia, iea, ioi, iua, oua, eie, eio, eiu, iei, iou, aei, oie, oio, oiu]
		mp (a(eiu)-2*3=6,e(ai)-3+2=5,i(eo)-2+1=3,o(i)-2,u(io)-2+1=3), value sum:6+5+3+2+3=19
		
	n=4, size: 35
	[aeae, eaea, iaea, oiae, uaea, eiae, ieae, ioia, iuae, ouae, eiea, eioi, eiua, ieia, ioua, eiei, eiou, ieie, ieio, ieiu, aeia, oiea, oioi, oiua, ioie, ioio, ioiu, aeie, aeio, aeiu, oiei, oiou, eaei, iaei, uaei]
	mp (a(eiu)-5+3+3=11,e(ai)-6+3=9,i(eo)-5+2=7,o(i)-3,u(io)-3+2=5), value sum:11+9+7+3+5 35
	
	 n=1: 5, n=2: 10, n=3: 19, n=4: 35, n=5: 68, n=6: 129, n=7: , n=8: , n=9: , n=10: 1749,
	 n=10: 1749, n=14: 23378; n=11: 3336, n=12: 6377, n=13: 12221, n=14: 23378, n=15: ,n=16: ,n=17: ,n=18: ,n=19:601345 ,n=20: 1151090,n=21:2203799, n=26: 56664154,
	 n=25:29599477, 
	 version 1: not good for n19
	 version 2: use map to count only string number for ending letters
	 n=126:663426255, n=1112:reach infinite, 8.902313033605166E307
	 
	 https://leetcode.com/problems/count-vowels-permutation/
	 n= 35, output: 569758867, expected: 569758867
	 n=40, 196669546, correct
	 n=56, 282083631 expected: 282083631, correct
	 n=57, 992947095, correct
	 n=58, 713808699, expected 713808698
	 n=60, 217630205, expected 217630190
	 n=61, 498521153, expected 498521110
	https://leetcode.com/problems/count-vowels-permutation/
	Success 	Details
	Runtime: 96 ms, faster than 8.64% of Java online submissions for Count Vowels Permutation.
	Memory Usage: 39.9 MB, less than 42.53% of Java online submissions for Count Vowels Permutation.
		n at:140, counted perm by mod:954786890
		n at:141, counted perm by mod:500530712
		n at:142, counted perm by mod:712817039
		n at:143, counted perm by mod:138318561
		n at:144, counted perm by mod:18208803
     */
    public int countPerm(int n ) {
    	int cnt=5;
    	if (n<=1) 
    		return cnt;
    	HashMap<Character,Double> mp= new HashMap<Character,Double>();
    	mp.put('a', (double) 1);mp.put('e', (double) 1);mp.put('i', (double) 1);mp.put('o', (double) 1);mp.put('u', (double) 1);
    	double m = Math.pow(10, 9) + 7;
        for (int i=2; i<=n; i++) {
        	HashMap<Character,Double> tmp= new HashMap<Character,Double>();
        	Set<Character> clist = mp.keySet();
        	for (Character k:clist) {
        		switch (k) {
        		// count each vowel could generate new string by rules, save in temp map
	        		case 'a':tmp.put(k,mp.get('e')+mp.get('i')+mp.get('u')); //eiu
	        		break;
	        		case 'e':tmp.put(k,mp.get('a')+mp.get('i'));			// ae
	        		break;
	        		case 'i':tmp.put(k,mp.get('e')+mp.get('o'));			// eo
	        		break;
	        		case 'o':tmp.put(k,mp.get('i'));						// i
	        		break;
	        		case 'u':tmp.put(k,mp.get('i')+mp.get('o'));			// io
	        		break;
        		}
        	};
        	// assign tmp map to processing map
        	mp = tmp;
        	double tmc=0;
        	for (Map.Entry<Character, Double> ent:mp.entrySet()) {
        		// calculate each vowel module, based on this math theory : (a+b+c)%m=(a%m+b%m+c%m)%m
        		double oldv=ent.getValue();
        		double newv=oldv%m;
        		ent.setValue(newv);
        		tmc +=newv;
        	}
        	cnt=(int)(tmc%m);
        	System.out.println("n at:"+i+", counted perm by mod:"+cnt);
        }
        System.out.println("module cnt:"+cnt);
        return cnt;
    }
    
    /* A slot machine has multiple wheels that are spun n times. 
     * In each spin, each wheel may have multiple stops from 1 to 9 and shows one random number on machine dashboard.
     * Given the number of spin n, determine the minimum number of stops on each wheel to produce the numbers displayed
     * on the dashboard for each spin. Then calculate the total stops.
     * Example:
     * n=4, spins=['712', '246','365','312'], total stop=7+5+3=15
     * n=4, spins=["137", "346", "115","724"], total stop=7+4+3=14
     * hist.add("1112");hist.add("1111");hist.add("1211");hist.add("1111"); total stop=2+1+1+1=5
     */
    public int slotWheels(List<String> history) {
    	if (history==null || history.size()==0) {
    		return 0;
    	}
    	int mach=history.get(0).length();
    	int accnum=0;
    	System.out.println("machine wheels: "+mach);
    	for (int m=0; m<mach; m++) {
    		System.out.println("m:"+m+", history: "+history);
	    	int max=0;
	    	for (int i=0; i<history.size(); i++) {
	    		String st=history.get(i);
	    		int submax=0;
	    		for (int j=0; j<st.length(); j++) {
	    			// change char to number
	    			int charnum=Character.getNumericValue( st.charAt(j));
	    			System.out.println("loop at j:"+j+", char at j:"+charnum+", submax:"+submax);
	    			if (charnum>submax) {
	    				submax=charnum;
	    			}
	    		}
	    		System.out.println("loop at i:"+i+", submax:"+submax+", of string:"+st);
	    		// remove the submax from st (i of history) 
	    		StringBuffer stb=new StringBuffer(st);
	    		int ind=stb.indexOf(String.valueOf(submax));
	    		stb.deleteCharAt(ind);
	    		history.set(i, stb.toString());
	    		
	    		// update max
	    		if (submax>max) {
	    			max=submax;
	    		}
	    	}
	    	accnum+=max;
    	}    	
    	System.out.println("return total stop:"+accnum);
    	return accnum;
    }
    
    /*
     * find second largest number from array 
     */
    public void findSecondLargeNum() {
    	int [] myarr = {22,33,55,66,44,66, 71, 69,21,12,8, 70,80};
    	//Arrays.sort(myarr);
    	System.out.println(Arrays.toString(myarr));     	
    	// descending order
    	//List<Integer> mylist= new ArrayList<Integer>();
//    	List<String> mylist= new ArrayList<String>();
//    	for (int i:myarr) {
//    		mylist.add(Integer.toString(i));
//    	}
//    	Collections.sort(mylist, Collections.reverseOrder());
//    	System.out.println(mylist);   	
    	int max=0;
    	int secMax=0;
    	for (int i=0; i<myarr.length; i++) {
    		System.out.println(" second max:"+secMax+", max:"+max+", at i:"+i);
    		if (myarr[i]>=max) {
    			if (max>secMax && max!=myarr[i]) {
    				secMax=max;
    			}
    			max=myarr[i];
    		} else if (myarr[i]>secMax) {
    			secMax=myarr[i];
    		}
    	}
    	System.out.println(" second max:"+secMax+", max:"+max);
    }
    
    /*
     * File process
     */
    public void fileProcess() {
    	// read string file name
    	Scanner scan = new Scanner(System.in);
    	String filename = scan.nextLine();
    	BufferedReader reader;
    	
    }
    
    /*
     * Complete the 'countDuplicate' function below.
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */
    public static int countDuplicate(List<Integer> numbers) {
    // Write your code here
        int cnt=0;
        System.out.println(numbers);
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i:numbers){
            if (mp.containsKey(i)){
                int t1=mp.get(i);
                t1++;
                mp.put(i,t1);
            } else {
                mp.put(i,0);
            }
        }
        System.out.println(mp);
        for (Map.Entry<Integer, Integer> ent: mp.entrySet()){
            if (ent.getValue()>0){
                cnt++;
            }
        }
        System.out.println("duplicated count:"+cnt);
        return cnt;
    }
    
    public void print3largest(int arr[]) 
    { 
        int i, first, second, third; 
  
        /* There should be atleast three elements */
        if (arr.length < 3) { 
            System.out.print(" Invalid Input "); 
            return; 
        } 
  
        third = first = second = Integer.MIN_VALUE; 
        for (i = 0; i < arr.length; i++) { 
            /* If current element is greater than 
            first*/
            if (arr[i] > first) { 
                third = second; 
                second = first; 
                first = arr[i]; 
            } 
            /* If arr[i] is in between first and 
            second then update second  */
            else if (arr[i] > second) { 
                third = second; 
                second = arr[i]; 
            } else if (arr[i] > third) 
                third = arr[i]; 
        } 
        System.out.println("Three largest elements are " + first + " " + second + " " + third); 
    } 
    
    /*
     * generalized GCD, write an algorithm to determine the GCD of N positive integers
     * input: positive integer array
     * output: an integer representing the GCD of the given positive integer array.
     * Example: arr={2,4,6,8,10}, output:2
     * 				{2,3,4,5,6}, output:1
     */
    public int generalizedGCD() {
    	int [] arr={15,3,9,18,6}; // {2,3,4,5,6}; // {2,4,6,8,10}; //{8,18,4,12,6}; {12,8,16,20}
    	int fgcd=1;
    	int gcd=1;
    	Arrays.sort(arr);	// sort ascending
    	System.out.println(Arrays.toString(arr)); //print out
    	int first=arr[0];
    	while (gcd<=first) {
    		boolean divall=true;
    		for (int i=0; i<arr.length; i++) {
    			if (arr[i]%gcd != 0) {
    				divall=false;
    				break;
    			}
    		}
    		if (divall) {
    			fgcd=gcd;
    		}
			gcd++;
    	}
    	System.out.println("general GCD:"+fgcd);
    	return gcd;
    }
    
    /*
     * 
    A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
    A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
	Given the sequence of up and down steps during a hike, find and print the number of valleys walked through. 
	8
	UDDDUDUU Output:1
	_/\      _
   \    /
    \/\/
    12 DDUUDDUDUUUD output:2
     */
    public int valleyCount(int steps, String path) {
    // Write your code here
        int level=0;
        int cnt=0;
        for (int i=0; i<steps; i++){
            if (path.charAt(i)=='U'){
                level++;
                if (level==0){
                    cnt++;
                }
            } else {
                level--;
            }
        }
        System.out.println(" value cnt:"+cnt);
        return cnt;
    }

    /*
	find longest possible reverse substring , ex 					 
	input: abmadam, output: madam
		   0123456
	input:	abc pqrrqp kl, output:pqrrqp
	input: abcpqrrqpklmnopponm output:mnopponm
	       0123456789012345678	
	n.log(n)
	
	find the longest palindromic substring
	https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
	https://leetcode.com/problems/longest-palindromic-substring/
	"uhrfjotnewtodhmbplsaolnpcdaohiytmfllukijouxipvqohtsgxbtfoxyfkfczkfwhzimbefiohmtimrcxbpgcxogystdkcqujvbxsgirpccdnvejtljftwkdpsqpflzwruwwdzovsbmwbcvlftkjnxqaguvtsycylqzquqkbnybnbaeahbxejhphwrpmymcemuhljwtuvxefqfzjhskuqhifydkxpnfwfxkpeexnjltfqwfvchphmtsrsyayxukvmlqodshqwbeaxhcxdbssnrdzvxtusngwqdxvluauphmmbwmgtazjwvolenegwbmjfwprfuswamyvgrgshqocnhirgyakbkkggviorawadzhjipjjgiwpelwxvtaegauerbwpalofrbghfhnublttqtcmqskcocwwwxpnckrnbepusjyohsrretrqyvgnbezuvwmzizcefxyumtdwnqjkgsktyuacfpnqocqjxcurmipjfqmjqrkdeqsfseyigqlwmzgqhivbqalcxhlzgtsfjbdbfqiedogrqasgmimifdexbjjpfusxsypxobxjtcwxnkpgkdpgskgkvezkriixpxkkattyplnpdbdifforxozfngmlgcunbnubzamgkkfbswuqfqrvzjqmlfqxeqpjaqayodtetsecmfbplscmslpqiyhhykftzkkhshxqvdwmwowokpluwyvavwvofwqtdilwqjgrprukzyhckuspyzaoe"

     */
    public String longReverseSub() {
    	String st ="uhrfjotnewtodhmbplsaolnpcdaohiytmfllukijouxipvqohtsgxbtfoxyfkfczkfwhzimbefiohmtimrcxbpgcxogystdkcqujvbxsgirpccdnvejtljftwkdpsqpflzwruwwdzovsbmwbcvlftkjnxqaguvtsycylqzquqkbnybnbaeahbxejhphwrpmymcemuhljwtuvxefqfzjhskuqhifydkxpnfwfxkpeexnjltfqwfvchphmtsrsyayxukvmlqodshqwbeaxhcxdbssnrdzvxtusngwqdxvluauphmmbwmgtazjwvolenegwbmjfwprfuswamyvgrgshqocnhirgyakbkkggviorawadzhjipjjgiwpelwxvtaegauerbwpalofrbghfhnublttqtcmqskcocwwwxpnckrnbepusjyohsrretrqyvgnbezuvwmzizcefxyumtdwnqjkgsktyuacfpnqocqjxcurmipjfqmjqrkdeqsfseyigqlwmzgqhivbqalcxhlzgtsfjbdbfqiedogrqasgmimifdexbjjpfusxsypxobxjtcwxnkpgkdpgskgkvezkriixpxkkattyplnpdbdifforxozfngmlgcunbnubzamgkkfbswuqfqrvzjqmlfqxeqpjaqayodtetsecmfbplscmslpqiyhhykftzkkhshxqvdwmwowokpluwyvavwvofwqtdilwqjgrprukzyhckuspyzaoe";

    			//"abcpqrrqpklmnopponm"; //"abcpqrrqpkl";// "abmadam";
    	String rev="";
    	int len=st.length();
    	int maxsub=0;
    	System.out.println(" input string len:"+len);
    	// for each sub string, starting at 0
    	for (int i=0; i<len; i++){
    		//another loop in the subs
    		for (int j=i+maxsub+1; j<=len; j++) {	//i=4:starting at 1(p), 2(pq), 3(pqr),4(pqrr),5(pqrrq),6(pqrrqp)
	    		// check this sub string is reversable
	    		String checksub =st.substring(i,j);	// a
	    		//System.out.println(" checksub:"+checksub+", at i:"+i+", j:"+j);
	    		StringBuffer sb= new StringBuffer(checksub);
	    		if (checksub.equals(sb.reverse().toString()) ) {
	    			if (checksub.length() > maxsub) {
	    				rev=checksub;	// ret="a", maxsub=1
	    				maxsub=checksub.length();
	    				//System.out.println(" keep rev:"+rev+", maxsub len:"+maxsub);
	    			}
	    		};
    		}
    	}
    	System.out.println(" return rev:"+rev);
    	return rev;
    }
    /*
Approach 3: Dynamic Programming

To improve over the brute force solution, we first observe how we can avoid unnecessary re-computation while validating palindromes. Consider the case "ababa". If we already knew that "bab" is a palindrome, it is obvious that "ababa" must be a palindrome since the two left and right end letters are the same.

We define P(i,j)P(i,j)P(i,j) as following:

P(i,j)={true,if the substring Si…Sj is a palindromefalse,otherwise. P(i,j) = \begin{cases} \text{true,} &\quad\text{if the substring } S_i \dots S_j \text{ is a palindrome}\\ \text{false,} &\quad\text{otherwise.} \end{cases} P(i,j)={true,false,​if the substring Si​…Sj​ is a palindromeotherwise.​

Therefore,

P(i,j)=(P(i+1,j−1) and Si==Sj) P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j ) P(i,j)=(P(i+1,j−1) and Si​==Sj​)

The base cases are:

P(i,i)=true P(i, i) = true P(i,i)=true

P(i,i+1)=(Si==Si+1) P(i, i+1) = ( S_i == S_{i+1} ) P(i,i+1)=(Si​==Si+1​)

This yields a straight forward DP solution, which we first initialize the one and two letters palindromes, and work our way up finding all three letters palindromes, and so on...
     */
    public String longReverseSub2() {
    	//String s ="uhrfjotnewtodhmbplsaolnpcdaohiytmfllukijouxipvqohtsgxbtfoxyfkfczkfwhzimbefiohmtimrcxbpgcxogystdkcqujvbxsgirpccdnvejtljftwkdpsqpflzwruwwdzovsbmwbcvlftkjnxqaguvtsycylqzquqkbnybnbaeahbxejhphwrpmymcemuhljwtuvxefqfzjhskuqhifydkxpnfwfxkpeexnjltfqwfvchphmtsrsyayxukvmlqodshqwbeaxhcxdbssnrdzvxtusngwqdxvluauphmmbwmgtazjwvolenegwbmjfwprfuswamyvgrgshqocnhirgyakbkkggviorawadzhjipjjgiwpelwxvtaegauerbwpalofrbghfhnublttqtcmqskcocwwwxpnckrnbepusjyohsrretrqyvgnbezuvwmzizcefxyumtdwnqjkgsktyuacfpnqocqjxcurmipjfqmjqrkdeqsfseyigqlwmzgqhivbqalcxhlzgtsfjbdbfqiedogrqasgmimifdexbjjpfusxsypxobxjtcwxnkpgkdpgskgkvezkriixpxkkattyplnpdbdifforxozfngmlgcunbnubzamgkkfbswuqfqrvzjqmlfqxeqpjaqayodtetsecmfbplscmslpqiyhhykftzkkhshxqvdwmwowokpluwyvavwvofwqtdilwqjgrprukzyhckuspyzaoe";
    			//"abcpqrrqpklmnopponm"; //"abcpqrrqpkl" a;// "abmadam" madam;
    	String s="abcpqrrqpkl";//"abcpqrrqpkl"; //"abmadam"; abfkfde
    			//01234567
    	String rev="";
    	int len=s.length();
    	int maxsub=0;int maxbeg=0;int maxend=0;
    	boolean [][] rec= new boolean [len][len];
    	for (int i=0; i<len; i++){
    		rec[i][i]=true;
    	}
    	System.out.println(" input string len:"+len);
    	for (int i=1; i<len; i++){
    		for (int j=0; j<i; j++) {
    			//System.out.println("i:"+i+",j:"+j+",val:"+st.substring(0,j+1));//rec[i][j]);
    			if (s.charAt(i)==s.charAt(j)) {
    				System.out.println("i:"+i+":"+s.charAt(i)+",j:"+j+":"+s.charAt(j));
    				if(i-j == 1 || rec[j+1][i-1] ) {
    					System.out.println("j+1:"+(j+1)+",i-1:"+(i-1)+",rec[j+1][i-1]:"+rec[j+1][i-1]);
    					rec[j][i]=true;    				
	    				if (maxend - maxbeg<i-j) {
	    					maxbeg=j; maxend=i;
	    					System.out.println("set maxbeg:"+maxbeg+", maxend:"+maxend);
	    				}
    				}
    			} else {
    				rec[j][i]=false;
    			}
    		}
    	}
    	for (int i=0; i<len; i++){
    		System.out.println(Arrays.toString(rec[i]));
    	}
    	//System.out.println(" maxsub:"+maxsub+",maxbeg:"+maxbeg+", maxend:"+maxend);
    	rev=s.substring(maxbeg,maxend+1);
    	System.out.println(" return rev:"+rev);
    	return rev;
    }  
    /*
     * Complete the 'playlist' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY songs as parameter.
     */
    public long playlist() {
    // Write your code here
    	Integer [] arr= {40,50,60,30,80};
    	List<Integer> songs = Arrays.asList(40,50,60,30,80);
    	System.out.println("song list size:"+songs.size());
        long pair=0;
        int m=60;
        for (int i=0; i<songs.size(); i++){
            for (int j=i+1;j<songs.size(); j++){
                System.out.println("song i:"+songs.get(i)+", song j:"+songs.get(j));
                if ((songs.get(i)+songs.get(j))%m==0 ) {
                    pair++;
                    System.out.println("paired songs");
                }
            }
        }
        System.out.println("return pair:"+pair);
        return pair;
    }
    
    /*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
1 Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
2 Input: l1 = [0], l2 = [0]
Output: [0]
3 Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1] 
    9,9,9,9,9,9,9
  + 9,9,9,9
    8,9,9,9,0,0,0,1
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // get the first number from node 1
        StringBuffer sb=new StringBuffer();
        while (l1!=null){
            int digi=l1.val;
            sb.insert(0,digi);
            l1=l1.next;
        }
        //System.out.println("number 1:"+sb);
        long num1=Long.parseLong(sb.toString());
        System.out.println("number 1:"+num1);
        // number 2
        sb=new StringBuffer();
        while (l2!=null){
            int digi=l2.val;
            sb.insert(0,digi);
            l2=l2.next;
        }
        long num2=Long.parseLong(sb.toString());
        System.out.println("number 2:"+num2);
        
        // add two numbers
        long num3=num1+num2;
        String str=String.valueOf(num3);
        System.out.println("output str:"+str+", len:"+str.length());
        // output node
        ListNode node3 = new ListNode();
        for (int i=0;i<str.length();i++) {
            //node3 = new ListNode();
            int num=Character.getNumericValue(str.charAt(i));
            //System.out.println("processing i:"+i+", val:"+num);
            node3.val=num;
            if (i<str.length()-1) {
                //node3.next=node3;
                ListNode node = new ListNode();
                node.next=node3;
                node3=node;
            }
        }
        ListNode pr = node3;
        while (pr!=null) {
        	System.out.println(" "+pr.val);
        	pr=pr.next;
        }
        return node3;
    }
    // version 2
    public ListNode addTwoNumber2(ListNode l1, ListNode l2) {
    	ListNode ret=new ListNode();
    	ListNode tail=ret;
    	ListNode sectail=ret;
    	ListNode n1=l1, n2=l2;
    	int sum=0;
    	boolean carry=false;
    	boolean loop=true;
    	while (loop) {
    		if (n1!=null || n2!=null) {
    			// add value: n1 + n2, save to ret
    			if (n1!=null && n2!=null) {
    				sum=n1.val+n2.val;
    				n1=n1.next; n2=n2.next;
    			} else if (n1!=null && n2==null) {
        			sum=n1.val;
        			n1=n1.next;
        		} else if (n1==null && n2!=null) {
        			sum=n2.val;
        			n2=n2.next;
        		}    			
    			if (carry) {
    				sum++;
    				carry=false;
    			}
    			if(sum>=10) {
    				carry=true;
    				sum = sum%10;
    			}
    			//System.out.println(" sum:"+sum+", carry:"+carry);
    			tail.val=sum;    			
    			ListNode tmp=new ListNode();
    			sectail=tail;
    			tail.next=tmp;
    			tail=tmp;    			
    		} else { // both n1 and n2 are null
    			if (carry)
    				tail.val=1;
    			else {
    				// remove the empty head value of zero
    				sectail.next=null; 
    			}
				break;
			}
    	}
    	ListNode pr = ret;
//        while (pr!=null) {
//        	System.out.println(" "+pr.val);
//        	pr=pr.next;
//        }
    	return ret;
    }
    /*
     create a new node list from int array, in order of array
     */
    public ListNode createListNode(int [] arr) {
    	ListNode head=new ListNode();
    	if (arr.length==0)
    		return null;
    	if (arr.length==1) {
    		head.val=arr[0];
    		return head;
    	}    	
    	head.val=arr[0];
    	ListNode tail=head;
    	System.out.println(" arr size"+arr.length);
    	for (int i=1;i<arr.length; i++) {
    		ListNode tmp=new ListNode();
    		tmp.val=arr[i];
    		tail.next=tmp;
    		tail=tmp;
    	}
    	ListNode pr = head;
        while (pr!=null) {
        	System.out.println(" "+pr.val);
        	pr=pr.next;
        }
    	return head;
    }
    
    /*
     Complete the plusMinus function below.
Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with places after the decimal.
Example
arr = [1,1,0,-1,-1]
There are elements, two positive, two negative and one zero. Their ratios are , and
Results are printed as:
0.400000
0.400000
0.200000
     */    
    static void plusMinus(int[] arr) {
        int [] rio=new int[3];
        //System.out.println(Arrays.toString(rio));
        for (int num:arr){
            if (num>0){
                rio[0]++;
            } else if (num<0){
                rio[1]++;
            } else {
                rio[2]++;
            }
        }        
        //System.out.println(Arrays.toString(rio));
        int arrLen=arr.length;
        for (int a:rio) {
            double d1=(double)a/arrLen;
            String ds = String.valueOf(d1); 
            int dslen=ds.length();
            if (dslen>=8) {
                ds=ds.substring(0,8);
            } else {
                StringBuffer zs= new StringBuffer();
                for (int i=0; i<8-dslen; i++) {
                    zs.append("0");
                }
                ds=ds+zs;
            }
            System.out.println(ds);
        }

    }
    // Complete the miniMaxSum function below.
    public void miniMaxSum(int[] arr) {
        long minsum=Long.MAX_VALUE;
        long maxsum=0;
        for (int i=0;i<arr.length; i++){
            long tmp=0;
            // add all number except for i position
            for (int j=0; j<arr.length; j++) {
            	//System.out.println("j ind:"+j+", value:"+arr[j]);
            	if (j!=i)
            		tmp+=arr[j];
            }
            System.out.println("temp value: "+tmp+", for i:"+i);
            if (tmp >maxsum) {
                maxsum=tmp;
                System.out.println("change maxsum:"+maxsum);
            }
            if (tmp<minsum) {
                minsum=tmp;
                System.out.println("change minsum:"+minsum);
            }
        }
        System.out.println(minsum+" "+maxsum);
    }
	public static void main(String[] args) {
		MyHome test= new MyHome();

		ArrayList<Integer> x= new ArrayList<Integer>();
		x.add(1);x.add(2);x.add(7);
		ArrayList<Integer> y= new ArrayList<Integer>();
		y.add(3);y.add(4);y.add(9);
		ArrayList<Integer> z= new ArrayList<Integer>();
		z.add(5);z.add(6);z.add(3);
		ArrayList<ArrayList<Integer>> rest =  test.findTuples(x, y, z);
//		System.out.println("return from findTuples, size:"+rest.size());
//		for (ArrayList<Integer> e:rest ) {
//			System.out.println(e.get(0)+","+e.get(1)+","+e.get(2));
//		}
		
        int width=10;  
        //with lambda  
        Drawable d2=()->{  
            System.out.println("Drawing "+width);  
        };  
        d2.draw();  
       
        // Creating a graph with 5 vertices
        Graph gh = new Graph();
        int V = 5; 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V); 
        for (int i = 0; i < V; i++) 
            adj.add(new ArrayList<Integer>()); 
        // Adding edges one by one 
        gh.addEdge(adj, 0, 1, true); 
        gh.addEdge(adj, 0, 4, true); 
        gh.addEdge(adj, 1, 2, true); 
        gh.addEdge(adj, 1, 3, true); 
        gh.addEdge(adj, 1, 4, true); 
        gh.addEdge(adj, 2, 3, true); 
        gh.addEdge(adj, 3, 4, true);           
        //gh.printGraph(adj); //original graph
        
//        int [] fromcity= {1,1,1,2,5};
//        int [] tocity =  {2,3,5,4,5};
//        // build graph city

        int arrdata [][] ={{1, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6} };
        //int arrdata [][] ={ { 1, 4 }, { 2, 3 },{ 3, 4 }, { 4, 5 },{ 5, 6 } }; 
        int arrlen =6; // arrdata.length;
        ArrayList<ArrayList<Integer>> dgraph = new ArrayList<ArrayList<Integer>>(arrlen+1);
        for (int i = 0; i < arrlen+1; i++) 
        	dgraph.add(new ArrayList<Integer>(arrlen+1));
        for (int i=0; i<arrdata.length; i++) {
        	gh.addEdge(dgraph, arrdata[i][0], arrdata[i][1], true);
        }
        //gh.printGraph(dgraph);
        
        //List<Integer> ret = gh.depthFirstSearch(dgraph, arrlen);
        //System.out.print(" depthFirstSearch max len returned values:\n");
        //ret.forEach(System.out::println);
        /*
        //(4,8,8,3,1) threshold=15, return: (4,8,3)
        int threshold =21; // 15;
        List<Integer> seq = new ArrayList<Integer>(); seq.add(4);seq.add(8);seq.add(8);seq.add(3);seq.add(1);
        seq.add(4);seq.add(8);seq.add(8);seq.add(3);seq.add(1);
        List<Integer> mseq = test.maxSubsequence(seq, threshold);
        mseq.forEach(System.out::println);
        */
        int arrY []={4,3,6,1,5}; // {4,3,6,1,5}; {1,3,5};
        int arrZ []={8,15,3,1,9};// {3,5,7}; // {8,15,3,1,9};
        y=new ArrayList<Integer>(); for (int i:arrY) y.add(i);
        z=new ArrayList<Integer>(); for (int i:arrZ) z.add(i);
        //int retval = test.minCost(y,z);
        int az []={0,1,2,1,2,3};
        //int az []={1,1,1,3,3,2,2,3,2,1,0,1,0,1,1,0,0,1,1,1}; 
        z=new ArrayList<Integer>(); for (int i:az) z.add(i);
//        int retval = test.longSubarray(z);
//        System.out.println ("return val:"+retval);
        int inp []={1,2,2,3,3,3,4,4,5,5,5,5,6,6,6,7,8,9,10}; 
        //test.freqOrder(inp, 1);
        String st="yum deed";
        //test.encyptCycle(st);
        int [][] twodem= {
                {0,1,1,0,0},
        		{0,1,1,1,0},
        		{0,0,1,1,0},
        		{0,1,1,1,0},
        		{0,1,1,1,0}
        };

        // convert arraylist
        ArrayList<Integer> onels;
        //List<List<Integer>> twols= new ArrayList<List<Integer>>();
        ArrayList<ArrayList<Integer>>  twols = new ArrayList<ArrayList<Integer>>();
        for (int [] i:twodem) {
        	onels = new ArrayList<Integer>();
        	System.out.println();
        	for (int j: i) {
        		System.out.print(" "+j); onels.add(j);
        	}
        	twols.add(onels);
        }
        //test.maxAllOneSize(twols);
        
//        long num = 105;
//        boolean ret = test.isPrime(num);
//        System.out.print(" ret:"+ret);
        int [] arr = {9, 2, 4, 5, 9, 4, 4 };
        test.longSubArr(arr);
        List<String> myst = new ArrayList<String>();
        myst.add("from");myst.add("Bank");myst.add("of");myst.add("America");myst.add("Mac");
        System.out.println(myst);
        Collections.sort(myst);
        //System.out.println(myst);
        //myst.forEach((i)->System.out.println(i));
        
        // Multiple parameters in lambda expression  
        Addable ad1=(a,b)->(a+b);  
        System.out.println(ad1.addition(10,20));
        
        List<Product> list=new ArrayList<Product>();            
        list.add(new Product(1,"HP Laptop",25000f));  
        list.add(new Product(3,"Keyboard",300f));  
        list.add(new Product(2,"Dell Mouse",150f));  
        list.add(new Product(4,"Xor",550f));
        //System.out.println("Sorting on the basis of name...");
        // implementing lambda expression  
        Collections.sort(list,(p1,p2)->{  
        	return p1.name.compareTo(p2.name);  
        	//return p1.id.compareTo(p2.id);
        });
        //Collections.sort(list);
        //list.forEach((p)->System.out.println(p.name)); 
        
        List<Float> productPriceList2 =list.stream()  
                .filter(p -> p.price > 20000)// filtering data  
                .map(p2->p2.price)        // fetching price  
                .collect(Collectors.toList()); // collecting as list  
        //System.out.println(productPriceList2);
        int[] numbers = new int[]{1, 5, 6, 7, 2};
        //System.out.println(test.findDifference(numbers));
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        //test.printArray(doubleArray);   // pass a Double array
        //test.printArray(charArray);   // pass a Character array
        //System.out.println(test.findDifference(charArray));
        //test.countPerm(144); //40, 144 problem
        List <String> hist = new ArrayList<String>();
        hist.add("1112");hist.add("1111");hist.add("1211");hist.add("1111");
        //test.slotWheels(hist);
        st = "71271"; 
        String str=st.replaceFirst("7", "");
        //System.out.println(" replace str:"+str);
        int arr1[] = { 12, 13, 1, 10, 34, 1 };
        //test.longReverseSub2(); //playlist(); //longReverseSub(); // mapExercise(); //.generalizedGCD();
        StringBuffer stb=new StringBuffer();
        stb.insert(0, 5);stb.insert(0, 2);
        //System.out.println("stb:"+stb);
        int numb1 = Integer.parseInt(stb.toString());
        String str1=String.valueOf(numb1);
//        for (int i=0;i<str1.length();i++) {
//        	System.out.println("char:"+str1.charAt(i));
//        	numb1=Character.getNumericValue(str1.charAt(i));
//        	System.out.println("char:"+str1.charAt(i)+", num:"+numb1);
//        }
        int [] num1={9,9,9,9,9,9,9};// {2,4,3};
        int [] num2={9,9,9,9}; // {5,6,4};
        ListNode tmp = new ListNode(2,null);
        //ListNode l1=test.createListNode(num1);
		//ListNode l2=test.createListNode(num2);
		//test.addTwoNumber2(l1, l2);
		if ("john"== "john") {
			System.out.println("john == john");
		}
		int a=5;
		loop:for (int i=1; i<3;i++) {
			for (int j=1; i<3;i++) {
				if (a==5) {
					break loop;
				}
				System.out.println(" i*j:"+i*j);
			}
		}
//		switch (a) {
//		// count each vowel could generate new string by rules, save in temp map
//    		case 1: System.out.println("case 1");
//    		case 2: System.out.println("case 2");
//    		case 5: System.out.println("case 5");
//    		case 6: System.out.println("case 6");
//    		default: System.out.println("default case");
//		}
//		Boolean flag=true;
//		//boolean flag=false;
//		if (flag = true) {
//			System.out.println("flag = true");
//		} else {
//			System.out.println("flag is false");
//		}
		Object obj=new Button("A");
		Panel pan= new Applet();
		new Vector(5,10); //int initialCapacity, int capacityIncrement
		double d1=(double)a/2; // 3;
		String ds = String.valueOf(d1); 
		//System.out.println("5/3:"+d1+", ds:"+ds+", len:"+ds.length());
		int dslen=ds.length();
		if (dslen>=8) {
			ds=ds.substring(0,8);
		} else {
			StringBuffer zs= new StringBuffer();
			for (int i=0; i<8-dslen; i++) {
				zs.append("0");
			}
			ds=ds+zs;
		}
		//System.out.println("format ds:"+ds);
		int [] num={1,2,3,4,5};
		//test.miniMaxSum(num);
		int n=20;
		BigInteger fac = new BigInteger("1");
        for (int i=1; i<=n; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        //System.out.println(fac);
        d1=7.87;
        d1 = n;
        System.out.println(d1);
        ds.indexOf("e"); 
	}
}
