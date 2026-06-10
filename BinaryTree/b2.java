package BinaryTree;

import java.util.*;

// Calculate height of a tree
// and Calculate Nodes of a tree
// sum of nodes

// very important ---  Calculate diameter of tree number of nodes in the longest path between 2 leaves

public class b2 {
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

    public static int height(Node root) { // 0(n)
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int countNodes(Node root) {// 0(n)
        if (root == null) {
            return 0;
        }
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);
        return lc + rc + 1;

    }

    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int leftSum=sum(root.left);
        int rightSum=sum(root.right);
        return leftSum+rightSum+root.data;
    }

    public static int diameter1(Node root){ // 0(n^2)
        if(root == null){
            return 0;
        }
        int leftDiam = diameter1(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter1(root.right);
        int rightHt = height(root.right);
        int selfDiam = leftHt + rightHt +1;
        return Math.max(selfDiam,Math.max(rightDiam,leftDiam));
    }

    // Best method to calculate Diameter
    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    public static Info diameter(Node root){ //0(n) Linear time complexity
     if(root == null){
        return new Info(0,0);
     }

     Info leftInfo= diameter(root.left);
     Info rightInfo = diameter(root.right);
     int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
     int ht= Math.max(leftInfo.ht,rightInfo.ht)+1;
     
     return new Info(diam,ht);
    }

    // 1
    // / \
    // 2   3
    // / \ / \
    // 4 5 6 7
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.print(height(root));
        System.out.println();
        System.out.print(countNodes(root));
        System.out.println();
        System.out.print(sum(root));
        System.out.println();
        System.out.print(diameter1(root));
        System.out.println();
        System.out.print(diameter(root).diam);
    }
}
