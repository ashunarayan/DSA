package Queue;

// stack using Deque
import java.util.*;

public class q9 {
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();
       public void push(int data){
        deque.addLast(data);
       }
       public int pop(){
        return deque.removeLast();
       }
    }

    public static void main(String args[]) {

    }
}
