package Heaps;

import java.util.*;
// Problem: The K Weakest Rows in a Matrix

// You are given an m × n binary matrix mat where:

// 1 represents a soldier

// 0 represents a civilian

// In each row:

// All the 1s (soldiers) appear before any 0s (civilians).

// The strength of a row is defined as the number of soldiers (1s) in that row.

// Your task is to return the indices of the k weakest rows in the matrix, ordered from weakest to strongest.

// A row i is weaker than row j if:

// The number of soldiers in row i is less than that in row j, or

// If both rows have the same number of soldiers, then the row with the smaller index is weaker.

public class h6 {
    public static class Row implements Comparable<Row> {
        int Soldierscount;
        int idx;

        public Row(int Soldierscount, int idx) {
            this.Soldierscount = Soldierscount;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.Soldierscount == r2.Soldierscount) {
                return this.idx - r2.idx;
            } else {
                return this.Soldierscount - r2.Soldierscount;
            }
        }
    }

    public static void main(String args[]) {
        int soldiers[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 },
        };
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0; i < soldiers.length; i++) {
            int Soldierscount = 0;
            for (int j = 0; j < soldiers[0].length; j++) {
                if (soldiers[i][j] == 1) {
                    Soldierscount++;
                }
            }
            pq.add(new Row(Soldierscount, i));
        }
        int k = 2;
        for (int i = 0; i < k; i++) {
            System.out.println("row" + pq.remove().idx);
        }
    }
}
