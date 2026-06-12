package BST;
//MIRROR A BST
public class bs5 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            return new Node(val);
        }
        if(root.data>val){
            root.left=insert(root.left,val);
        }
        else{
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static Node createMirror(Node root){//0(N) time complexity
        if(root==null){
            return null;
        }
        Node leftSubtree=createMirror(root.left);
        Node rightSubtree=createMirror(root.right);
        root.left=rightSubtree;
        root.right=leftSubtree;
        return root;
    }
  public static void main(String args[]){
    int values[]={8,5,3,6,10,11,14};
    Node root=null;
    for(int i=0;i<values.length;i++){
        root=insert(root,values[i]);
    }
    root=createMirror(root);
  }  
}
