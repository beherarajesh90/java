package com.java.dsa.searching;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        int arr[] = {10, 20, 40, 60, 5, 8};
        int n = arr.length;
        int x = 60;
        int index = search(arr,x,n);
        System.out.println(x+" is at index "+index);
    }

    private static int search(int[] arr, int x, int n) {
        int low=0,high=n-1;
        while (low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid]==x){
                return mid;
            }
            else if (arr[low] < arr[mid] ){
                if(x>=arr[low] && x< arr[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(x>arr[mid] && x<=arr[high]) {
                    low = mid + 1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
