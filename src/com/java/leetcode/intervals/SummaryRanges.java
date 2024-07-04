package com.java.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        int start=0,end=0;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<nums.length; i++){
            if(i<nums.length-1 && nums[i]==nums[i+1]-1){
                sb.append(nums[i]).append("->");
                while (i<nums.length-1 && nums[i]==nums[i+1]-1){
                    i++;
                }
                sb.append(nums[i]);
                res.add(sb.toString());
                sb.setLength(0);
            }else{
                res.add(nums[i]+"");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = summaryRanges(new int[]{0,1,2,4,5,7});
        for (String s: res){
            System.out.println(s);
        }
    }
}
