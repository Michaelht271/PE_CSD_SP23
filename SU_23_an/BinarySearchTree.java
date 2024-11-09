package pe;

public class BinarySearchTree {
   Node root;
   
 public BinarySearchTree() {
	// TODO Auto-generated constructor stub
}
   
   Node insert(Node node, Teacher data) {
	   
	   if (node == null) {
		   return new Node(data);
	   }
	   
	   if(data.code < node.data.code) {
		   node.left=  insert(node.left, data);
	   } else if( data.code > node.data.code) {
		   node.right = insert(node.right, data);
	   }
	   return node;
	   
   }
   
    void constructTree(Teacher[] teachers) {
	   for(Teacher teacher : teachers) {
		   root = insert(root, teacher);
	   }
	  
   }
    
    
    void increaseCoeff(Node node, double M) {
    	if(node == null ) return;
    	
    	node.data.coeff += M/2.0;
    	
    	increaseCoeff(node.left, M);
    	increaseCoeff(node.right, M);
    }

    
    double getMaxCoeff(Node node) {
    	if(node == null) return -1;
    	double maxLeft = getMaxCoeff(node.left);
    	double maxRight = getMaxCoeff(node.right);
    	return Math.max(node.data.coeff, Math.max(maxLeft, maxRight));
    }
    
    void printNodes(Node node, int level) { 
    	if(node == null ) {
    		return;
    	}
    	
    	System.out.println ("< " + node.data.toString() + ", " + level +" >");
    	
    	printNodes(node.left, level+1);
    	printNodes(node.right, level+1);
    }
    
    int height (Node node) {
    	if(node == null ) return 0;
    	return 1 + Math.max(height(node.left), height(node.right));
    }
    
    void determineBal(Node node) {
    	if(node == null) return;
    	node.bal = height(node.left)- height(node.right);
    	determineBal(node.left);
    	determineBal(node.right);
    	
    	
    }
    
    void preOrder(Node node) {
    	if(node == null ) return;
    	
    	System.out.println(node.data.toString());
    	preOrder(node.left);
    	preOrder(node.right);
    }
    
    void TreeBubbleSort(Teacher[] teachers) {
    	int length = teachers.length;
    	for(int i = 0; i < length-1; i++) {
    		for(int j = 0; j < length -i-1; j++) {
    			if(teachers[j].code < teachers[j+1].code) {
    				Teacher tempt = teachers[j];
    				
    				teachers[j] =  teachers[j+1];
    				teachers[j+1] = tempt;
    				
    			}
    		}
    	}
    }
    
 // Method to delete a node
    Node delete(Node node, int code) {
        if (node == null) {
            return null;
        }
        
        // Recursively find the node to delete
        if (code < node.data.code) {
            node.left = delete(node.left, code);
        } else if (code > node.data.code) {
            node.right = delete(node.right, code);
        } else {
            // Node to be deleted found

            // Case 1: Node has no children (leaf node)
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: Node has one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 3: Node has two children
            // Find the inorder successor (smallest node in the right subtree)
            node.data = minValue(node.right);

            // Delete the inorder successor
            node.right = delete(node.right, node.data.code);
        }
        return node;
    }

    // Helper method to find the minimum value node in a given subtree
    private Teacher minValue(Node node) {
        Teacher minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    // Method to delete a teacher by their code (entry point for user)
    public void deleteByCode(int code) {
        root = delete(root, code);
    }
    // Method to check if the tree is AVL
    boolean isAVL(Node node) {
        if (node == null) {
            return true; // An empty tree is balanced (AVL)
        }

        // Check if the balance factor is between -1 and 1 for each node
        if (Math.abs(node.bal) > 1) {
            return false; // Not balanced
        }

        // Recursively check the left and right subtrees
        return isAVL(node.left) && isAVL(node.right);
    }
}
