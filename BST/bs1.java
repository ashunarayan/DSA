
// WHAT IS BST

// A BINARY SEARCH TREE IS A BINARY TREE IN WHICH ALL THE LEFT CHILD NODES HAVE VALUES LESS THAN THE PARENT NODE AND ALL THE RIGHT CHILD NODES HAVE VALUES GREATER THAN THE PARENT NODE
// TIME COMPLEXITY OF SEARCH IN BST IS O(H) WHERE H IS THE HEIGHT OF THE TREE
// IN A BALANCED BST, H=O(LOG N) WHERE N IS THE NUMBER OF NODES IN THE TREE
// IN A SKEWED BST, H=O(N)

// BUILD A BST

// Search in BST
package BST;

public class bs1 {

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

    // INSERT
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // INORDER
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // SEARCH
    public static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (key < root.data) return search(root.left, key);
        return search(root.right, key);
    }

    // FIND INORDER SUCCESSOR
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // DELETE
    public static Node delete(Node root, int val) {
        if (root == null) return null;

        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            // case 1: leaf
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2: single child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // case 3: two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    
    public static void main(String args[]) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for (int v : values) {
            root = insert(root, v);
        }

        inorder(root);
        System.out.println();

        System.out.println(search(root, 1) ? "found" : "not found");

        root = delete(root, 3);
        inorder(root);
    }
}
