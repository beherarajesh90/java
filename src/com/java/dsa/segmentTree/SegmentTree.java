package com.java.dsa.segmentTree;

public class SegmentTree {

    //Constructing a Segment Tree
    static int CST(int ss,int se,int si,int arr[],int tree[]){

        if(ss == se){
            tree[si] = arr[ss];
            return tree[si];
        }

        int mid = (ss+se)/2;

        tree[si] = CST(ss,mid,2*si+1,arr,tree) + CST(mid+1,se,2*si+2,arr,tree);
        return tree[si];
    }

    //Getting sum of range provided (range query)
    static int getSum(int qs,int qe,int ss,int se,int si,int tree[]){
        if(qs>se || qe<ss) return 0;
        if(ss>=qs && se<=qe) return tree[si];
        int mid = (ss+se)/2;
        return getSum(qs,qe,ss,mid,2*si+1,tree) + getSum(qs,qe,mid+1,se,2*si+2,tree);
    }

    //Updating the segment tree according to the element replaced in the array (update query)
    static void update(int ss,int se,int i,int diff,int si,int tree[]){

        if(i<ss || i>se) return;

        tree[si] += diff;

        if(se>ss){
            int mid = (ss+se)/2;
            update(ss,mid,i,diff,2*si+1,tree);
            update(mid+1,se,i,diff,2*si+2,tree);
        }

    }

    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60};
        int tree[] = new int[4*arr.length]; //size of segment tree = 4*N =>roughly

        CST(0,arr.length-1,0,arr,tree);
        int diff = 60-arr[1];
        update(0,arr.length-1,1,diff,0,tree);
        System.out.println(getSum(0,2,0,arr.length-1,0,tree));
    }

}
