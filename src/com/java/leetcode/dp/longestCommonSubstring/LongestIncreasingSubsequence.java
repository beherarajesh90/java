package com.java.leetcode.dp.longestCommonSubstring;

public class LongestIncreasingSubsequence {
    public static int lisUsingDP(int[] arr,int n){
        int[] lis = new int[n];
        lis[0] = 1;
        for(int i=0; i<n; i++){
            lis[i]=1;
            for(int j=0;j<i; j++){
                if(arr[j]<arr[i]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }

        int res = 0;
        for(int i=0; i<n; i++){
            if(res<lis[i])
                res = lis[i];
        }
        return res;
    }

    public static int lisUsingBinarySearch(int[] arr, int n){
        int[] tail = new int[n];
        tail[0] = arr[0];
        int lisLength = 1;
        for(int i=1; i<n; i++){
            if(arr[i]>tail[lisLength-1]){
                tail[lisLength] = arr[i];
                lisLength++;
            }else{
                int idx = findCeilIndexUsingBinarySearch(tail,0, lisLength,arr[i]);
                tail[idx] = arr[i];
            }
        }
        return lisLength;

    }

    private static int findCeilIndexUsingBinarySearch(int[] arr, int fromIndex, int toIndex, int x) {
        int l=fromIndex,r=toIndex;
        while (l<r){
            int m = l+(r-l)/2;
            if(arr[m]>=x){
                r=m;
            }else{
                l=m+1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        System.out.println(lisUsingBinarySearch(arr, arr.length));
    }
}
