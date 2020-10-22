import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyApp2 {
	static MyApp2 myInst;
	private MyApp2() {
		// this is default constructor
	}
	
	//@Thread, make this method thread safe.
	public static synchronized MyApp2 getInstance() {
		if (myInst == null) {
			myInst= new MyApp2();
		}
		return myInst;
	}
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int mp=0;
        Arrays.sort(ar);
        for (int i=0; i<n; i++) {
            System.out.println(" sorted pair i:"+i+", ar[i]:"+ar[i] );
        }    
        for (int i=0; i<n-1; i++) {
            if (ar[i]==ar[i+1] ) {
                System.out.println(" found a pair i:"+i+", i+1:"+i+1+", ar[i]:"+ar[i]+", ar[i+1]:"+ar[i+1] );
                mp++;
                i++;
            } 
        }
        System.out.println(" matched pair:"+mp);
        return mp;
    }
    
	// the head is reference, changed here is not reflected in the caller. So we need return value.
	//function: move tail to the front: eg [1,2,3,4->null]-->[4,1,2,3->null] 
	public Node moveToFront(Node head) 
    { 
        /* If linked list is empty or it contains only 
           one node then simply return. */
           if(head == null || head.nxt == null)  
              return head; 
  
        /* Initialize second last and last pointers */
        Node secLast = null; 
        Node last = head; 
  
        /* After this loop secLast contains address of  
           second last  node and last contains address of  
           last node in Linked List */
        while (last.nxt != null)   
        { 
           secLast = last; 
           last = last.nxt;  
        } 
        System.out.println("\n second last node:"+secLast.data);
        System.out.println(" the last node:"+last.data);
        /* Set the next of second last as null */
        secLast.nxt = null; 
        System.out.println(" new secLast node next:"+secLast.nxt);
        /* Set the next of last as head */
        last.nxt = head; 
        //System.out.println(" new last node next:"+last.nxt.data);
        /* Change head to point to last node. */
        head = last;
        return head;
    }
	/*
	 List of contiguous numbers , find the larger sum set
8,-5,4,3,4,-5,-5,4,6,-3; => [8 -5] [4 3 4] [-5 -5] [4 6], removing the last -3
=> 3 11 -10 10 =>14 -10 10 => 4, 10 => largest sum=14
	 */
	public int maxSubContiguous(int [] arr) {
		int maxs=0;
		//List<int[]> alist =Arrays.asList(arr);
		List<Integer> alist = new ArrayList<Integer>();

		for (int x:arr) {
			alist.add(x);
		}
		System.out.println(alist);
		// 1. all positive number
		boolean allpos=true;
		for (int x:arr) {
			if (x<0) {
				allpos=false;
				break;
			} else {
				maxs+=x;
			}
		}
		if (allpos) {
			System.out.println("all number are positive, ret:"+maxs);
			return maxs;
		}
		// 1. all negative number
		maxs=Integer.MIN_VALUE; System.out.println("min value:"+maxs); 
		boolean allneg=true;
		for (int x:arr) {
			if (x>=0) {
				allneg=false;
				break;
			} else {
				if (x>maxs) {
					maxs=x;
				}
			}
		}
		if (allneg) {
			System.out.println("all number are negative, ret:"+maxs);
			return maxs;
		}
		maxs=0;
		//3. mix number
		/*
		 If there are as positive as negative numbers in the list. Denote positive numbers as P, and negative numbers as N. 
		 Then our list will look like that (in terms of java regular expressions): [PN]{n}, 
		 where 'n' is length of the list (list 1,2,3 = PPP; list 1,5,-10,2,5 = PPNPP). 
		 This notation shows, that the whole list is divided into groups of interchanging positive and negative numbers. 
		 Note that largest sum could be as single positive group, as sequence of positive-negative-positive groups. 
		 For example list 8,9,-2,3 (PPNP) - largest sum has the whole list.
		 */
		// remove leading negative number in head and tail
		System.out.println(" removing head negative size:"+alist.size());
		int ind=0;
		while (alist.get(ind)<0) {
			System.out.println(" alist ind="+ind+", value:"+alist.get(ind));			
			alist.remove(ind);
		}
		System.out.println("after removing head negative ");
		//System.out.println (alist);
		
		System.out.println(" removing tail negative size:"+alist.size());
		ind=alist.size() - 1;
		while (alist.get(ind)<0) {
			//System.out.println(" alist ind="+ind+", value:"+alist.get(ind));			
			alist.remove(ind);
			ind--;
		}
		System.out.println("after removing tail negative ");
		System.out.println (alist);
		
		int sum=0;ind=0;
		while (ind<alist.size()) {
			System.out.println(" alist ind="+ind+", value:"+alist.get(ind)+", sum:"+sum);
			if (sum<0) {
				//alist.remove(ind);
				sum=0;
			} else {								
				sum+=alist.get(ind);
				ind++;
			}
		}
		System.out.println (alist);
		System.out.println ("sum:"+sum);
		return sum;
	}
	
	//subSeqSumX
	/*
	given array Arr, and number X, find sub sequence set sum=x
	boolean subSeqSumX(List<Integer> ls, int x): return true: found the sub sequence; false: did not find.
	eg, list 8,5,4,3,4,5,4,6,3, x=9 : true, x=19 true; x=29 ?
	 */
	public boolean subSeqSumX(List<Integer>list, int x) {
		boolean ret=false;
		Collections.sort(list);
		System.out.println("input x:"+x+ ", sorted list ");
		System.out.println(list);
		if (list.size()==0)
			return ret;
		int subsum=list.get(0);
		for (int i=0; i<list.size(); i++) {
			System.out.println("loop on i:"+i);
			subsum=list.get(i);
			if (subsum==x) {
				ret = true;
				System.out.println("found subsum:"+subsum+", i="+i);
				return ret;
			}
			if (subsum > x) {				
				System.out.println("over X subsum:"+subsum+", i="+i);
				return ret;
			}
			for (int j=i+1; j<list.size(); j++) {
				subsum+=list.get(j);
				System.out.println("check subsum:"+subsum+", j="+j);
				if (subsum==x) {
					ret = true; return ret;
				}
				if (subsum > x) {
					subsum-=list.get(j);
					break;
				}
			}
		}
		return ret;
	}
	
	/*
	 * binary tree search
	 */
	public Node some(Node root, int k) {
		if (root==null || root.key==k) {
			return root;
		}
		if (root.key>k) {
			return some(root.left, k);
		}
		return some(root.right,k);		
	}

	public void printArray(int [] arr) {
		System.out.println(" The int array:");
		for (int i:arr) {
			System.out.print(" "+i);
		}
		System.out.println();
	}
	/*
	 * merge two arrays, arr1[0], arr2[0], arr1[1],arr2[1], ...
	 */
	public int [] mergeTwoArray(int [] arr1,int [] arr2) {
		//System.out.println("input 2 arrays");
		printArray(arr1);
		printArray(arr2);
		
		int arr1Len=arr1.length;
		int arr2Len=arr2.length;
		int[] merg = new int[arr1Len+arr2Len];
		int commLen;
		if (arr1Len>arr2Len) {
			commLen=arr2Len;
		} else {
			commLen=arr1Len;
		}
		// merge common length elements
		System.out.println("common length:"+commLen+", arr1Len:"+arr1Len+", arr2Len:"+arr2Len);
		for (int i=0; i<commLen; i++) {
			merg[2*i]=arr1[i];
			merg[2*i+1]=arr2[i];
		}
		System.out.println("common merge");
		printArray(merg);
		// merge extra length elements
		if (arr1Len>arr2Len) {
			System.out.println(" merge arr1 ext");
			for (int i=commLen;i<arr1Len; i++) {
				merg[commLen+i]=arr1[i];
			}
		} else if (arr2Len>arr1Len) {
			for (int i=commLen;i<arr2Len; i++) {
				merg[commLen+i]=arr2[i];
			}
		}
		System.out.println("output arrays");
		printArray(merg);
		return merg;
	}
	public static void main(String[] args) {
		//MyApp2 app2= new MyApp2();
		MyApp2 appInst = MyApp2.getInstance();
		String str1="abcdefg";  // len=7
		StringBuffer rev= new StringBuffer();
		int len= str1.length();
		System.out.println("String Len:"+len);
		for (int i=0; i<str1.length(); i++) {
			rev.append(str1.charAt(len-i-1));
		}
		System.out.println(rev.toString());
		
		Node head = new Node(1); Node node2= new Node(2); Node node3= new Node(3); Node node4= new Node(4);
		node3.nxt=node4;
		node2.nxt=node3;		
		head.nxt=node2;
		System.out.println("input node:");
		Node temp = head;
		while (temp!=null) {
			System.out.print(" "+temp.data); temp=temp.nxt;			
		}
		Node mv=head;
		// move to right by n
//		int n=3;
//		for (int i=1;i<=n; i++) {
//			mv = appInst.moveToFront(mv); // do it again = move right by 2 
//		}
//		temp = mv;
//		while (temp!=null) {
//			System.out.print(" "+temp.data); temp=temp.nxt;			
//		}
		//int [] arr1= {8,4,3,4,4,6};	//sum=29
		//int [] arr1= {-5,-5,-5,-3};	//sum=-3
		//int [] arr1= {-5,-5,-5,-3, 8, 4,-5,1, -7,-8,-9}; //sum=8
		//int [] arr1= {8,-5,4,3,4,-5,-5,4,6,-3}; //sum=14
		//int [] arr1= {3,-2,-5,2,-10,10,7,-4,-3,6,5,-8,9}; //sum=22
		int [] arr1= {3,-2,-5,2,-10,10,7,-4,-3,6,5,-28,9};	//sum=9
		//int ret = appInst.maxSubContiguous(arr1);
		
		int [] arr= {8,5,4,3,4,5,4,6,3};	// 19 true: 5, 6, 8;28:true(0-6) 29:false; 30:false;31:true(1-7);32:true(3-8);
		List<Integer> ls = new ArrayList<Integer>();
		for (int x:arr) {
			ls.add(x);
		}
		int target=32;
		//boolean res = appInst.subSeqSumX(ls,target);
		//System.out.println(" subSeqSumX="+res);
		
		Node n1= new Node(2,null, null);
		Node n2= new Node(7,null, null);
		Node hd = new Node(4,n1,n2);
		Node sm = appInst.some(hd, 4);
		if (sm!=null) {
			System.out.println("returned node key:"+sm.key);
		} else {
			System.out.println("returned node is empty ");
		}
		int [] aa= {4,5,4,6};
		int [] ab= {8,5,4,3,4,9};
		appInst.mergeTwoArray(aa,ab);
	}
}
