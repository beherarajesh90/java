package com.java.multithreading.practice.locks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExecutorExample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Future<Integer> future = forkJoinPool.submit(new CalculateSumTask(1,10000));
        try {
            System.out.println(future.get());
            System.out.println(System.currentTimeMillis()-start);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}

class CalculateSumTask extends RecursiveTask<Integer> {

    int start;
    int end;
    CalculateSumTask(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        if(end-start <= 100){
            for(int i=start; i<end; i++){
                sum+=i;
            }
        }else {
            //find mid
            int mid = (start+end)/2;
            CalculateSumTask leftTask = new CalculateSumTask(start, mid);
            CalculateSumTask rightTask = new CalculateSumTask(mid+1, end);

            //fork the subtasks for parallel execution
            leftTask.fork();
            rightTask.fork();

            //combine the results of the subtasks
            int leftSum = leftTask.join();
            int rightSum = rightTask.join();
            return leftSum+rightSum;

        }
        return sum;
    }
}
