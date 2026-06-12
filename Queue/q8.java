package Queue;
// QUEUE REVERSAL
// input 12345
// output 54321
import java.util.*;
public class q8 {
    public static void reverse(Queue<Integer> q){
         Stack<Integer> s= new Stack<>();
         while(!q.isEmpty()){
            s.push(q.remove());
         }
         while(!s.isEmpty()){
            System.out.println(s.pop()+" ");
         }
    }
    public static void main(String args[]){
   Queue<Integer> q= new LinkedList<>();
   q.add(1);
   q.add(2);
   q.add(3);
   q.add(4);
   q.add(5);
   reverse(q);

   while(!q.isEmpty()){
    System.out.println(q.remove()+" ");
   }
    }
}
