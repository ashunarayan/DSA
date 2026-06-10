

import java.util.*;

//MINIMUM DISTANCE BETWEEN TWO NODES IN A BINARY TREE
public class b7 {
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

    // APPROACH1
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean founleft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if (founleft || foundRight) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static int distance(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }

        // i-1 is LCA index
        return (path1.size() - i) + (path2.size() - i);
    }

    // APPROACH2
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);
        if (leftLca != null && rightLca != null) {
            return root;
        }
        if (leftLca != null) {
            return leftLca;
        }
        return rightLca;
    }

    public static int lcaDist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDist=lcaDist(root.left,n);
        int rightDist=lcaDist(root.right,n);
        if(leftDist==-1&&rightDist==-1){
            return -1;
        }
        else if(leftDist==-1){
            return rightDist+1;

        }else{
            return leftDist+1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
     Node lca=lca2(root,n1,n2);
     int dist1=lcaDist(lca,n1);
     int dist2=lcaDist(lca,n2);
     return dist1+dist2;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(distance(root, 4, 5));
        System.out.println(minDist(root,4,6));
    }
}
// //| Approach       | Time     | Space              |
// | -------------- | -------- | ------------------ |
// | Path method    | O(n)     | O(n)               |
// | **LCA method** | **O(n)** | **O(1)** recursion |
