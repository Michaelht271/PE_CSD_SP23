package peL3;

public class Node {
     Worker data;
     Node left, right;
     int bal;
     public Node () {
    	 
     }
     
     public Node (Worker data) {
    	 this.data = data;
    	 this.left = this.right = null;
    	 this.bal = 0;
     }
     
     
     public String toString () {
    	 return data.toString();
     }
}
