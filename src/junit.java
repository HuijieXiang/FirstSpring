import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;


public class junit {
    @Test
    public void test_isEmpty_true() {
    	Stack stk= new Stack();
    	assertTrue(stk.isEmpty());
        //fail("Not yet implemented");
    }
    
    @Test
    public void test_isEmpty_false() {
    	Stack stk= new Stack();
    	Node anode = new Node(1);
    	stk.push(anode);
    	assertFalse(stk.isEmpty());
    }
    
    @Test
    public void test_push_empty() {
    	Stack stk= new Stack();
    	Node anode = new Node(1);
    	stk.push(anode);
    	assertFalse(stk.isEmpty());
    }
    @Test
    public void test_push_NotEmpty() {
    	Stack stk= new Stack();
    	Node anode = new Node(1);
    	stk.push(anode);
    	
    	Node anode2 = new Node(2);
    	stk.push(anode2);
    	assertFalse(stk.isEmpty());
    }

}
