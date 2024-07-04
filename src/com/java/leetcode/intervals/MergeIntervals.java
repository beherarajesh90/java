package com.java.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, Comparator.comparingInt(l -> l[0]));
        Arrays.sort(intervals, new ListComparator());
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0]<=prev[1]){
                prev[1]=intervals[i][1];
            }else{
                res.add(prev);
                prev=intervals[i];
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{8,10},{15,18},{2,6}};
        int[][] res = merge(intervals);
        System.out.println(Arrays.deepToString(res));
    }
}

class ListComparator implements Comparator<int[]>{

    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0]-o2[0];
    }
}
