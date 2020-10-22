package com.point;
import java.lang.invoke.*;
import java.lang.invoke.*;

public class ABC {
	int a;
	int b;
//	ABC(int a1,int b1){
//		a=a1;
//		b=b1;
//	}
	/*
	 * Fibonacci sequence
	n = 	0 	1 	2 	3 	4 	5 	6 	7 	8 	9 	10 	11 	12 	13 	14 	...
	xn = 	0 	1 	1 	2 	3 	5 	8 	13 	21 	34 	55 	89 	144 233 377 ...
	 */
	public void fib(int n) {	// n>=1
		System.out.println("0 ");
		int i0=0, i1=1;
		for (int j=1;j<=n; j++) {
			System.out.print(i1+" ");
			int tmp=i0;
			i0=i1; i1=tmp+i1;
		}
		System.out.println();
	}
	public void feb(int n1, int n2, int n3) {
		if (n1==0 && n3>0) {
			System.out.println("0");
			System.out.println("1");
		}
		if ( n3==0) 
			return;
		// print out the first number
		System.out.println(n1+n2);	// 1st: 0+1; 2nd: 
		feb(n2,n1+n2, --n3);
		
	}
	
	public void feb2(int n ) {
		if (n==0)
			return;
		int n1=0;
		int n2=1;
		System.out.println(n1);
		//System.out.println(n2);
		for (int i=0;i<n; i++) {
			int sum=n1+n2;
			System.out.println(sum);
			n1=n2;
			n2=sum;
		}
	}
	
	public String reverse(String str) {
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse().toString();
		
	}
	
	public void findLongWord(String in) {
		int maxlen=0;
		String [] arry = in.split(" ");
		for (String st:arry) {
			//System.out.println(st);
			if (st.length()>maxlen)
				maxlen=st.length();
		}
		System.out.println("The MaxStringLen:"+maxlen);
	}
	public static void main(String[] args) {
		// to print out febernatch number, for example: n=5, print out: 0,1,1,2,3,5
		ABC myabc = new ABC();
		//myabc.feb(start, next, n);
		//myabc.feb2(n);
		System.out.println(myabc.reverse("testing1"));
		
		String mixs="The quick brown fox jumped over the lazy dog";
		mixs.intern();
		myabc.findLongWord(mixs);
		
		Test mytest = Test.getTest();
		mytest.say();
		Test myt2 = Test.getTest();
		Test myt3 = Test.getTest();
		myabc.fib(14);

		int n1=10, n2=15;
		int gcd=1;
        for(int i = 1; i <= n1 && i <= n2; ++i)
        {
            // Checks if i is factor of both integers
            if(n1 % i==0 && n2 % i==0)
                gcd = i;
        }
        System.out.println(" gcd:"+gcd );
	}

}
