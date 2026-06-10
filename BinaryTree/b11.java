package BinaryTree;

// invert a binary tree
public class b11 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node invert(Node root) {
        if (root == null) {
            return null;
        }
        Node lc = invert(root.left);
        Node rc = invert(root.right);
        root.right = lc;
        root.left = rc;
        return root;

    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        invert(root);
        preorder(root);
    }
}
