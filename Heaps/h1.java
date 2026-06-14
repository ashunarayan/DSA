package Heaps;
// PRIORITY QUEUE USING HEAP
import java.util.*;
public class h1 {

    static class Student implements Comparable<Student>{ //overriding compareTo method
        String name;
        int rank;
        Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }
    public static void main(String args[]){
    PriorityQueue<Integer> pq1=new PriorityQueue<>();
    pq1.add(3);//0(logn) time complexity to add element
    pq1.add(4);
    pq1.add(1);
    pq1.add(7);
    pq1.add(5);
    
    
    while(!pq1.isEmpty()){
        System.out.println(pq1.peek());//0(1) time complexity to peek element
        pq1.remove(); //0(logn) highest priority element delete
    }
    //Reverse order
    PriorityQueue<Integer> pq2=new PriorityQueue<>(Comparator.reverseOrder());
    pq2.add(4);
    pq2.add(1);
    pq2.add(7);
    pq2.add(5);
    System.out.println("Reverse order");
    while(!pq2.isEmpty()){
        System.out.println(pq2.peek());
        pq2.remove();
    }

    PriorityQueue<Student> pq3=new PriorityQueue<>();
    pq3.add(new Student("A",4));
    pq3.add(new Student("B",1));
    pq3.add(new Student("C",3));
    pq3.add(new Student("D",2));

    while(!pq3.isEmpty()){
        System.out.println("Student name: "+pq3.peek().name+" Student rank: "+pq3.peek().rank);
        pq3.remove();
    }
    

}
}