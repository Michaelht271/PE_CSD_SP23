/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class student {

    String name;
    int id; // key

    public student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name + ", " + id; //To change body of generated methods, choose Tools | Templates.
    }
}

class node {

    student data;
    node left, right;
    int level;
    int bal;

    public node(student data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return data.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}

class bst {

    node root;

    public bst() {
        root = null;
    }

    public bst(student[] input) {
        root = null;
        for (student std : input) {
            insert(std);
        }
    }

    void insert(student std) {
        node[] res = search(std);
        if (res[0] != null) { // có rồi thì không chèn
            return;
        }
        node new_node = new node(std);
        if (res[1] == null) { // parent = null, cây rỗng
            root = new_node;
        } else if (res[1].data.id < std.id) {
            res[1].right = new_node;
        } else {
            res[1].left = new_node;
        }
    }

    void in_giam() {
        in_giam(root);
    }

    private void in_giam(node t) {
        if (t == null) {
            return;
        }
        in_giam(t.right);
        System.out.print(t + " ");
        in_giam(t.left);
    }

    node[] search(student std) {
        node t = root, parent = null;
        while (t != null && t.data.id != std.id) {
            parent = t;
            if (t.data.id < std.id) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        return new node[]{t, parent};
    }

    int tinh_tong() {
        return tinh_tong(root);
    }

    private int tinh_tong(node t) {
        if (t == null) {
            return 0;
        }
        int s = tinh_tong(t.right);
        s += t.data.id;
        return s + tinh_tong(t.left);
    }

    int height() {
        int max_level = -1;
        Queue q = new LinkedList();
        q.add(root);
        root.level = 0;
        while (!q.isEmpty()) {
            node t = (node) q.poll();
            System.out.print(t + "-" + t.level + ", ");
            if (max_level < t.level) {
                max_level = t.level;
            }
            if (t.left != null) {
                q.add(t.left);
                t.left.level = t.level + 1;
            }
            if (t.right != null) {
                q.add(t.right);
                t.right.level = t.level + 1;
            }
        }
        return max_level + 1;
    }

    int height_recur() {
        return height_recur(root);
    }

    private int height_recur(node t) {
        if (t == null) {
            return 0;
        }
        int hl = height_recur(t.right),
                hr = height_recur(t.left);
        return Integer.max(hl, hr) + 1;
    }

    boolean is_avl() {
        return is_avl(root);
    }

    private boolean is_avl(node t) {
        if (t == null) {
            return true;
        }
        int hl = height_recur(t.left),
                hr = height_recur(t.right);
        return is_avl(t.left) && is_avl(t.right) && Math.abs(hr - hl) <= 1;
    }

    void delete(student std) {
        node[] res = search(std);
        if (res[0] == null) { // chưa có thì không xóa
            return;
        }
        if (res[0].left != null && res[0].right != null) {
            node t = res[0].left, parent_t = res[0];
            while (t.right != null) {
                parent_t = t;
                t = t.right;
            }
            res[0].data = t.data;
            res[0] = t;
            res[1] = parent_t;
        }
        // xóa nút res[0] có nhiều nhất 1 con và cha của nó là res[1]
        node con_lai = res[0].left;
        if (con_lai == null) {
            con_lai = res[0].right;
        }
        if (res[1] == null) {
            root = con_lai;
        } else {
            if (res[1].left == res[0]) {
                res[1].left = con_lai;
            } else {
                res[1].right = con_lai;
            }
        }
    }

    boolean delete_min_id() {
        if (root == null) {
            return false;
        }
        node t = root.left, parent_t = null;
        while (t.left != null) {
            parent_t = t;
            t = t.left;
        }
        // xóa nút t có nhiều nhất 1 con và cha của nó là res[1]
        node con_lai = t.right;
        if (parent_t == null) {
            root = con_lai;
        } else {
            parent_t.left = con_lai;
        }
        return true;
    }

    void preorder() {
        Stack<node> S = new Stack<>();
        node t = root;
        for (;;) {
            while (t != null) {
                System.out.print(t + "-");
                if (t.right!=null) S.push(t.right);
                t = t.left;
            }
            if (S.empty()) {
                break;
            }
            t = S.pop();
        }
    }
}

public class JavaApplication8 {

    public static void main(String[] args) {
        bst T = new bst(new student[]{
            new student("5", 5), new student("2", 2), new student("7", 7),new student("1", 1), 
            new student("3", 3), new student("4", 4), new student("6", 6), new student("8", 8)
        }); T.preorder(); System.out.println("--------------");
        T.in_giam();
        T.delete_min_id();
        System.out.println("");
        T.in_giam();
        T.delete(new student("5", 5));
        System.out.println("");
        T.in_giam();
        T.height();
        if (T.is_avl()) {
            System.out.println("AVL");
        } else {
            System.out.println("NO AVL");
        }
        System.out.println("Tong = " + T.tinh_tong());
        System.out.println("Height = " + T.height_recur());
    }
}
