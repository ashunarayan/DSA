package BST;
// Sorted array to Balanced BST
//0(N) time complexity


public class bs6 {
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
    public static Node createBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
       int mid=(st+end)/2;
       Node root=new Node(arr[mid]); 
       root.left=createBST(arr,st,mid-1);
       root.right=createBST(arr,mid+1,end);
       return root;
    }
    
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    


    public static void main(String args[]){
  int arr1[]={3,5,6,8,10,11,12};
  Node root=createBST(arr1,0,arr1.length-1);
    inorder(root);
}
}