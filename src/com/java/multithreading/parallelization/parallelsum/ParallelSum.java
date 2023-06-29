package com.java.multithreading.parallelization.parallelsum;

public class ParallelSum {

    private ParallelWorker[] workers;
    private int numOfThreads;

    public ParallelSum(int numOfThreads) {
        this.numOfThreads = numOfThreads;
        this.workers = new ParallelWorker[numOfThreads];
    }

    public int sum(int[] arr) {

        int size = (int) Math.ceil(arr.length / numOfThreads);

        for (int i = 0; i < numOfThreads; i++) {
            workers[i] = new ParallelWorker(arr, i * size, (i + 1) * size);
            workers[i].start();
        }

        try {
            for (ParallelWorker p : workers) {
                p.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int total=0;

        for(ParallelWorker p:workers){
            total+=p.getPartialSum();
        }

        return total;
    }
}
