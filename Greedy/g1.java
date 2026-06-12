package Greedy;

// select maximum number of activities that can be performed by a single person,
// activities are sorted according to their end times
// start=[10,12,20]
//end=[20,25,30]
//ANS=2(A0 & A2)
import java.util.*;

public class g1 { // 0(n) time complexity
    // if end time is not sorted then time complexity is 0(nlog(n))
    // this is the code if end time are not shorted
    public static void main(String args[]) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 8, 9 };

        // sorting
        int activities[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        // lambda function -> shortform

        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));

        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        // first activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) { // no overlapping
                // activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];

            }
        }
        System.out.println("max activities=" + maxAct);
        for(int i=0;i<ans.size();i++){
       System.out.println("A"+ans.get(i)+" ");
        }
        System.out.println();

    }
}
