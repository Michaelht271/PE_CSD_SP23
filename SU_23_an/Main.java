package pe;

public class Main {
    
    public static void main(String [] args) {
        Teacher[] teachers = {
                new Teacher(5,5),
                new Teacher(3,3),
                new Teacher(2,2),
                new Teacher(4,4),
                new Teacher(7,7),
                new Teacher(6,6),
                new Teacher(8,8),
                new Teacher(1,1),
                new Teacher(9,9),
        };
        
        BinarySearchTree bst = new BinarySearchTree();
        
        // Construct the BST with the teachers array
        bst.constructTree(teachers);
        double maxCoeff = bst.getMaxCoeff(bst.root);
        bst.increaseCoeff(bst.root, maxCoeff);

        // Print all nodes in <data, level> format
        System.out.println("Nodes in <data, level> format:");
        bst.printNodes(bst.root, 0);

        // Determine the bal field for all nodes
        bst.determineBal(bst.root);

        // Output all teachers in pre-order traversal
        System.out.println("Pre-order traversal:");
        bst.preOrder(bst.root);
        System.out.println();

        // Sort teachers in decreasing order of code
        bst.TreeBubbleSort(teachers);

        // Print sorted teachers
        System.out.println("Sorted teachers:");
        for (Teacher teacher : teachers) {
            System.out.print(teacher + " ");
        }
        System.out.println();

        // Check if the tree is AVL after insertion and balancing
        System.out.println("Is the tree AVL after insertions? " + bst.isAVL(bst.root));

        // Example: Delete a teacher by code (e.g., code = 5)
        System.out.println("Deleting teacher with code 5...");
        bst.deleteByCode(5);

        // Print the updated tree after deletion
        System.out.println("Updated tree after deletion:");
        bst.printNodes(bst.root, 0);

        // Output the tree in pre-order traversal after deletion
        System.out.println("Pre-order traversal after deletion:");
        bst.preOrder(bst.root);

        // Check if the tree is AVL after deletion
        System.out.println("Is the tree AVL after deletion? " + bst.isAVL(bst.root));
    }
}
