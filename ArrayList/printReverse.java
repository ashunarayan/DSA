import java.util.ArrayList;
public class  printReverse{
    public static void main(String args[]){
  ArrayList<Integer> list=new ArrayList<>();
  list.add(2);
  list.add(5);
  list.add(9);
  list.add(6);
  list.add(8);
  // reverse 
//   for(int i=list.size()-1;i>=0;i--){
//     System.out.print(list.get(i)+" ");
//   }

//MAX
int max=Integer.MIN_VALUE;
for(int i=0;i<list.size();i++){
    // if(max<list.get(i)){
    //     max=list.get(i);
    // }

    max=Math.max(max,list.get(i));
}
System.out.print(max);

    }
}