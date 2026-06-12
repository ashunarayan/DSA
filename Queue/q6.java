package Queue;
// First non-repeating letter in a stream of characters
// NOTE MOSTLY IF WE STREAM OF CHARACTERS THEN IN MOSTLLY TIME USE QUEUES
// input - aabccxb
// output-  a,-1,b,b,b,b,x
import java.util.*;

// linear time complexity

public class q6 {
public static void printNonRepeating(String str){
    int freq[] = new int[26]; // 'a'-'z'
    Queue<Character> q= new LinkedList<>();

    for(int i=0;i<str.length();i++){
        char ch=str.charAt(i);
        q.add(ch);
        freq[ch-'a']++;
        while(!q.isEmpty() && freq[q.peek()-'a']>1){
            q.remove();
        }
        if(q.isEmpty()){
            System.out.println(-1+" ");
        }else{
            System.out.println(q.peek()+" ");
        }
    }
    System.out.println();
}
    public static void main(String args[]){
   String str="aabccxb";
   printNonRepeating(str);
    }
}
