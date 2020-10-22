import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Anytest {

	public static void main(String[] args){
	//int [] myarr = {22,33,55,66,44,66, 71, 69,21,12,8, 70,80};
/*
from Deleepkumar Vuppalapati (internal) to everyone:    4:12 PM
Find the elements that are present in "All the Arrays" and "How many times its present"
e.g.: If input is 3 Arrays like below,
a1 = ['A042', 'B004', 'A025', 'A042', 'C025']
a2 = ['B009', 'B040', 'B004', 'A042', 'A025', 'A042']
a3 = ['A042', 'A025', 'B004']
The result should be:
'A042'---> 5 times
'A025'---> 3 times
'B004'---> 3 times
 */
	//ArrayList<String> a1 = new ArrayList<String>();
	String [] a1 = {"A042", "B004", "A025", "A042", "C025"};
	String [] a2 = {"B009", "B040", "B004", "A042", "A025", "A042"};
	String [] a3 = {"A042", "A025", "B004"};
	ArrayList<String> out = new ArrayList<String>();
	HashMap<String , Integer> hm = new HashMap<String , Integer>();
	for (String a:a1) {
		if (hm.containsKey(a)) {
			int val=hm.get(a);
			val++;
			hm.put(a, val);
			} else {
			hm.put(a, 1);
			}
		}	
	//hm.forEach(K,V)->(System.out.println(k));
	for (String a:a2) {
		if (hm.containsKey(a)) {
			int val=hm.get(a);
			val++;
			hm.put(a, val);
			} else {
			hm.put(a, 1);
			}
		}
	for (String a:a3) {
		if (hm.containsKey(a)) {
			int val=hm.get(a);
			val++;
			hm.put(a, val);
			} else {
			hm.put(a, 1);
			}
		}	
	System.out.println(hm);
	List<String> multPres = new ArrayList<String>();
	hm.forEach( (k,v) -> 
		{
			if (v>1) {
				System.out.println( k + "=>" + v );
				multPres.add(k);
			}
		} 
	);
	System.out.println(multPres);

   List<String> list = new ArrayList<>();
   //final Integer  ordinal=0;
   //AtomicInteger ordinal = new AtomicInteger(0);
   int[] ordinal = { 0 };
    list.forEach(s -> {
      ordinal[0]++;
    	//ordinal.getAndIncrement();
    });

	
	}
}
