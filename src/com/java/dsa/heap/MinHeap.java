package com.java.dsa.heap;

public class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;

    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[capacity];
    }

    int parent(int index) {
        return (index - 1) / 2;
    }

    int left(int index){
        return (2 * index + 1)/2;
    }

    int right(int index){
        return (2 * index + 2)/2;
    }

    //Function to extract minimum value in heap and then to store
    //next minimum value at first index.
    int extractMin()
    {
        if (heap_size <= 0){
            return -1;
        }
        if (heap_size == 1){
            heap_size--;
            return harr[0];
        }
        int min = harr[0];
        harr[0] = harr[heap_size-1];
        heap_size--;
        minHeapify(0);
        return min;
    }

    //Function to insert a value in Heap.
    void insertKey(int k)
    {
        if(heap_size == capacity){
            return;
        }
        heap_size++;
        int i = heap_size-1;
        harr[i] = k;
        while (i!=0 && harr[parent(i)]>harr[i]){
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    //Function to delete a key at ith index.
    void deleteKey(int i)
    {
        if(i>heap_size-1){
            return;
        }
        decreaseKey(i,Integer.MIN_VALUE);
        extractMin();

    }

    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int newVal)
    {
        harr[i] = newVal;
        while (i!=0 && harr[parent(i)]>harr[i]){
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;
        if (left < heap_size && harr[smallest]>harr[left]) smallest = left;
        if (right < heap_size && harr[smallest]>harr[right]) smallest = right;
        if (smallest!=i){
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            minHeapify(smallest);
        }
    }

}

