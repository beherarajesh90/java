package com.java.multithreading.parallelization.parallelsum;

public class ParallelWorker extends Thread{

    private int[] arr;
    private int low;
    private int high;
    private int partialSum;

    public ParallelWorker(int[] arr,int low,int high){
        this.arr=arr;
        this.low=low;
        this.high=Math.min(arr.length,high);
    }

    @Override
    public void run(){
        partialSum = 0;
        for(int i=low;i<high;i++){
            partialSum+=arr[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
}
