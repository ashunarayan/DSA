package Greedy;

import java.util.*;
// Min Absolute Difference Pairs

// given two arrays A and B of equal length n.pair each element of array A to an element in array B,such that sum S of absolute differences of all the pairs is minimum.
// A=[1,2,3]
// B=[2,1,3]
// ans=0
public class g3 {
    public static void main(String args[]) {//0(nlogn)
        int a[] = { 1, 2, 3 };
        int b[] = { 2, 1, 3 };
        Arrays.sort(a);
        Arrays.sort(b);
        int minDiff = 0;
        for (int i = 0; i < a.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }
        System.out.println(minDiff);
    }
}
