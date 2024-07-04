package com.java.dsa.heap;

//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class KMostOccurringElements {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.kMostFrequent(arr, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    //Function to print the sum of frequencies of k numbers
    //with most occurrences in an array.
    int kMostFrequent(int arr[], int n, int k) {
        // your code here
        Map<Integer, Integer> m = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey()) :
                        Integer.compare(b.getValue(), a.getValue())
        );
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            pq.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            result += pq.remove().getValue();
        }
        return result;
    }
}
