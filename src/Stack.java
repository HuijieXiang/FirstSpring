
public class Stack {
	private Node node;
	//private Node head;
	private Node tail;
	
	public boolean isEmpty() {
		if (node==null)
			return true;
		else 
			return false;
	}
	
	public void push(Node no) {
		no.nxt=null;
		if (node==null) {
			node=no;
			tail = node;
		} else {
			Node cur=this.node;
			while (cur.nxt!=null) {
				cur=cur.nxt;
			} 
			cur.nxt=no;
			tail = no;
		}
	}
	
	public Node peek() {		
		if (node==null) {
			return null;
		} else {
			Node cur=this.node;
			while (cur.nxt!=null) {
				cur=cur.nxt;
			}
			return cur;
		}
	}
	
	public Node pop() {
		Node retnode=node;
		if (node==null || node.nxt==null) {
			return retnode;
		} else if (node.nxt==null) {
			node=null;
			return retnode;
		} else {
			Node pre=node;
			Node cur=node.nxt;
			while (cur.nxt!=null) {
				pre=cur;
				cur=cur.nxt;
			} 
			retnode =cur;
			pre.nxt=null;
			return retnode;
		}
	}
	
	public void printstack() {
		Node cur=node;
		if (node==null)
			System.out.println(" Empty stack !");
		while (cur!=null) {
			System.out.println(" stack value:"+cur.data);
			cur=cur.nxt;
		}
	}
}
