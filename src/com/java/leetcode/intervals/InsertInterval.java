package com.java.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> resultArr = new ArrayList<>();
        int i=0;

        //insert the new interval
        while (i<intervals.length && intervals[i][1]<newInterval[0]){
            resultArr.add(intervals[i]);
            i++;
        }

        while (i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }

        resultArr.add(newInterval);

        //eleminate the already covered intervals
        while (i<intervals.length){
            resultArr.add(intervals[i]);
            i++;
        }
        return resultArr.toArray(new int[resultArr.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] result = insert(intervals, new int[]{4,8});
        System.out.println(Arrays.deepToString(result));
    }
}
