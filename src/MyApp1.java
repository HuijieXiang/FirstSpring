import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

class Add extends Thread {
	int value;
 
	public void run() {
		value = 1 + 2;
	}
}
 
class Mul extends Thread {
	int value;
 
	public void run() {
		value = 1 * 2;
	}
}

public class MyApp1{
	public static void main(String[] args){
		Comparator<Player> comparator = (p1, p2) -> p1.getRanking() - p2.getRanking();
		Comparator<Player> revComparator = (p1, p2) -> p2.getRanking() - p1.getRanking();
		Add t1 = new Add();
		Mul t2 = new Mul();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double n = ((double)t2.value/t1.value);
		System.out.println(n);
		
		List<Integer> arrlist = new ArrayList<Integer>();
		arrlist.add(3);arrlist.add(4);arrlist.add(2);arrlist.add(1);
		Collections.sort(arrlist);
		//Collections.reverseOrder(arrlist);
		System.out.println(arrlist);
		
		Player play1=new Player("John", 34, 4);
		Player play2=new Player("Bob", 35, 5);
		Player play3=new Player("Mark", 31, 1);
		List<Player> plays = new ArrayList<Player>();
		plays.add(play1);plays.add(play2);plays.add(play3);
		System.out.println(plays);
		Comparator<Player> rev = Collections.reverseOrder(comparator );
		//plays.sort (revComparator);
		plays.sort (rev);
		System.out.println(plays);
		
        ExecutorService executor = Executors.newFixedThreadPool(20);    
        List<Future<String>> list = new ArrayList<Future<String>>();
        List<String> slist = new ArrayList<String>();
        Callable<String> callable = new ExecutorCallableExample1();    
    
        for(int i=0; i< 3; i++){    
            Future<String> ftr = executor.submit(callable);    
            list.add(ftr);    
        }    
        for(Future<String> fut : list){    
            try {    
                System.out.println(new Date()+ "::"+fut.get());    
    
            } catch (Exception e) {    
                e.printStackTrace();    
            }    
        }
        System.out.println("A" + "B" + 'A');
        executor.shutdown(); 
        System.out.println('A' + 'B');
        char [] str={'i','n','c','l','u','d','e','h','e','l','p'};  
        System.out.println(str.toString()); 
        byte x = 12;  
        byte y = 13;  
        //byte result = x + y;  
        //System.out.println(result);  
	}
}