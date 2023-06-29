package com.java.multithreading.parallelization.parallelsum;

import java.util.Arrays;

public class SequentialSum {

    public int sum(int[] arr){
        return Arrays.stream(arr).sum();
    }

}
