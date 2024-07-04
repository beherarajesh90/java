package com.java.leetcode.arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int i=0, j=nums.length-1;
        while(i<j){
            swap(i,j,nums);
            i++;j--;
        }

        i=0;j=k-1;
        while(i<j){
            swap(i,j,nums);
            i++;j--;
        }

        i=k;j=nums.length-1;
        while(i<j){
            swap(i,j,nums);
            i++;j--;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        RotateArray ra = new RotateArray();
        ra.rotate(nums, k);
        for (int n: nums){
            System.out.print(n+" ");
        }
    }
}
