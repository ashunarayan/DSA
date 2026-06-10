package BinaryTree;

import java.util.*;

public class b12 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Map<String, Integer> freq = new HashMap<>();
    List<Node> ans = new ArrayList<>();

    public List<Node> findDuplicateSubtrees(Node root) {
        serialize(root);
        return ans;
    }

    private String serialize(Node node) {
        if (node == null) return "#";

        String left = serialize(node.left);
        String right = serialize(node.right);

        String key = node.data + "," + left + "," + right;

        int count = freq.getOrDefault(key, 0);
        if (count == 1) {   // 2nd time seen => add once
            ans.add(node);
        }
        freq.put(key, count + 1);

        return key;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);

        root.left.left = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(3);

        root.right.left.left = new Node(3);

        b12 obj = new b12();
        List<Node> duplicates = obj.findDuplicateSubtrees(root);

        // Print only root values of duplicate subtrees
        for (Node n : duplicates) {
            System.out.println(n.data);
        }
    }
}
