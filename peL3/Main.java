package peL3;

public class Main {
    public static void main(String[] args) {
        Worker[] workers = {
            new Worker(1, "Nguyen Khac Anh", 20),
            new Worker(5, "Tran Duc Thang", 22),
            new Worker(3, "Nguyen Van Nam", 24),
            new Worker(9, "Hoang Gia Bao", 28),
            new Worker(2, "Le Van Phuoc", 23),
            new Worker(7, "Pham Minh Tam", 21),
        };

        BInarySearchTree bst = new BInarySearchTree();

        // Tạo cây nhị phân tìm kiếm từ mảng Worker
        bst.constructTree(workers);

        // Câu 1: Tìm Node với key = 3 và in Node đó cùng Parent Node
        System.out.println("Câu 1: Tìm Node với key = 3");
        Node[] result = bst.findNodeByKey(3);
        if (result[0] != null) {
            System.out.println("Node: " + result[0]);
        } else {
            System.out.println("Node với key = 3 không tìm thấy.");
        }
        if (result[1] != null) {
            System.out.println("Parent Node: " + result[1]);
        } else {
            System.out.println("Không tìm thấy Parent Node hoặc Node là gốc.");
        }

        // Câu 2: Chèn Node vào cây
        System.out.println("\nCâu 2: Chèn Node mới với key = 4");
        Worker newWorker = new Worker(4, "Vu Thi Lan", 26);
        bst.insert(bst.root, newWorker);
        bst.printTree(bst.root, "", true); // In cây sau khi chèn

        // Câu 3: In cây theo thứ tự giảm dần
        System.out.println("\nCâu 3: In cây theo thứ tự giảm dần");
        bst.desOrder(bst.root);

        // Câu 4: Đếm số Worker dưới 25 tuổi
        System.out.println("\n\nCâu 4: Số lượng Worker dưới 25 tuổi");
        int count = bst.CountWorkerLower25(bst.root);
        System.out.println("Số Worker dưới 25 tuổi: " + count);

        // Câu 5: Xóa Node bên phải nhất
        System.out.println("\nCâu 5: Xóa Node bên phải nhất");
        Node[] rightMostNode = new Node[]{bst.root, null};  // Mảng chứa Node bên phải nhất và Parent
        bst.delRightMostNode(rightMostNode);
        bst.printTree(bst.root, "", true); // In cây sau khi xóa Node bên phải nhất

     // Câu 6: Determine the height of the tree using level-order traversal
        System.out.println("\nCâu 6: Determining the height of the tree using level-order traversal");
        int height = bst.findHeight(bst.root);
        System.out.println("Height of the tree is: " + height);

        // Câu 7: Sắp xếp mảng Worker theo key và tạo lại cây có chiều cao lớn nhất
        System.out.println("\nCâu 7: Sắp xếp mảng Worker và tạo cây có chiều cao lớn nhất");
        bst.createLagrestHightTree(workers);
        bst.printTree(bst.root, "", true); // In cây có chiều cao lớn nhất
    }
}
