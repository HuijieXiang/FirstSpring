
public class Node {
	int data; 
    Node nxt;
    Node left;
    Node right;
    int key;
    
    Node(int d) {data = d; nxt = null; };
    
    Node(int k, Node l, Node r) {key = k; left = l; right=r; };
}

