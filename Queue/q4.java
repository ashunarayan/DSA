package Queue;
// implementation of queue using java collection framework
import java.util.*;
public class q4 {
    public static void main(String args[]){
  Queue<Integer> q= new LinkedList<>();//ArrayDeque
  q.add(1);
  q.add(2);
  q.add(3);
  while(!q.isEmpty()){
    System.out.println(q.peek());
    q.remove();
  }
    }
}
