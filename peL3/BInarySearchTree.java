package peL3;

import java.util.LinkedList;
import java.util.Queue;

public class BInarySearchTree {
  Node root;
  
  public BInarySearchTree() {
	  
  };
//  TẠO BinarrySearchTree
  public void  constructTree(Worker [] workers ) {
	  for(Worker t : workers ) {
		  root = insert(root,t);
	  }
  }
  
  
  //Câu 2 :  Chèn Node 
  public Node insert (Node node , Worker data ) {
	  if(node == null) {
		  return new Node(data);
	  }
	  
	  if(node.data.key > data.key) {
		  node.left = insert(node.left, data);
	  } else if( node.data.key < data.key) {
		  node.right = insert (node.right, data);
	  }
	  
	  return node;
  }
  
  
  // Câu 1: Tìm Node
  public Node[] findNodeByKey (int key ) {
	  Node[] result = new Node[2];
	  Node [] node = new Node[2];
	  node[0] = root;
	  node[1] = null;
	  result = findNode(node, key);
	  
	  return result;
  }
  public Node[] findNode (Node[] node ,int key  ) {
	  Node [] result = new Node [2];
	 if(node[0] == null ) {
		 result[0] = null;
		 result[1] = node[1];
		 return result;
	 }
	  
	  if(node[0].data.key == key ) {
		  result[0]= node [0];
		  result[1 ] = node[1];
		  return result;
	  }
	  
	  if(node[0].data.key > key ) {
		  result[0] = node[0].left;
		  result[1] =node[0];
		  return  findNode(result, key);
	  } else {
		  result[0] = node[0].right;
		  result[1] =node[0];
		  return findNode(result, key);
	  }
  }
  
  // Câu 3: Output by descending Order 
    
  public void desOrder (Node node){
	  if(node == null) return;
	  desOrder(node.right);
	  System.out.print(node.data.toString() + ", ");
	  desOrder(node.left);
  
  }
  
  //Câu 4:  Count worker less than 25 age 
  public int CountWorkerLower25(Node node) {
	  int count = 0;
	  if( node == null ) return count;
	  
	  if(node.data.age < 25 ) count ++;
	  
	  int countleft = CountWorkerLower25(node.left);
	  int countRight = CountWorkerLower25(node.right);
	  
	  count += countleft + countRight;
	  return count;
  }
  
  
  // Câu 5 delet -right most node
  
  public void delRightMostNode(Node[] node ) {
	  Node[] result = new Node[2];
	  
	  
	  if(node[0].right == null) {
		  if(node[0].left == null) {
			  node[1].right = null;
			  System.out.println("Delete sucessfully ");
			  return;
		  } else {
	     	  node[1].right = node[0].left;
		      System.out.println("Delete sucessfully ");
		      return;
		  }
	  } else {
		  result[0] = node[0].right;
		  result[1] = node[0];
		  delRightMostNode(result);
	  }
	  
	  
  }
  
  // Câu 6 
  // Method to determine the height of the tree using level-order traversal
  public int findHeight(Node root) {
      if (root == null) {
          return 0;
      }

      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      int height = 0;

      while (!queue.isEmpty()) {
          int levelSize = queue.size();
          // Process each level
          for (int i = 0; i < levelSize; i++) {
              Node current = queue.poll();
              if (current.left != null) {
                  queue.add(current.left);
              }
              if (current.right != null) {
                  queue.add(current.right);
              }
          }
          // Increment height after processing each level
          height++;
      }

      return height;
  }
  
  // Câu 7 
  
  public Worker[] sortArray(Worker[] workers ) {
	  int length = workers.length;
	  for(int i = 0 ; i< length -1 ; i++) {
		  for(int j = 0 ; j < length -1 - i; j++) {
			  
			  if(  workers[j].key > workers[j+1].key ) {
				  
				  Worker t = workers[j];
				  workers[j] = workers[j+1];
				  workers[j+1] = t;
			  }
		  }
	  }
	  return workers;
  }
  
  public void createLagrestHightTree(Worker[] workers ) {
	  
	  Worker[] w = sortArray(workers);
  
	  constructTree(w);
	  
  }
  
  
  // thêm   // Thêm phương thức in cây để kiểm tra cấu trúc cây (không bắt buộc)
  public void printTree(Node node, String indent, boolean last) {
      if (node != null) {
          System.out.print(indent);
          if (last) {
              System.out.print("R---- ");
              indent += "   ";
          } else {
              System.out.print("L---- ");
              indent += "|  ";
          }
          System.out.println(node.data);
          printTree(node.left, indent, false);
          printTree(node.right, indent, true);
      }
  }
  
  
  
}
  