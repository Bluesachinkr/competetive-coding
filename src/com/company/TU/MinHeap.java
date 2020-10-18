package com.company.TU;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int current;

    private final int Front = 1;
    MinHeap(int MaxSize){
       this.heap = new int[MaxSize];
       this.current=0;
       this.size =0;
       this.heap[0] = Integer.MIN_VALUE;
    }

    public void insert(int data){
        heap[++size] = data;
        this.current = size;

        while (heap[current] < heap[parent(current)]){
            swap(current,parent(current));
            this.current = parent(current);
        }
    }

    private void swap(int current, int parent) {
        int temp = heap[current];
        heap[current] = heap[parent];
        heap[parent] = temp;
    }

    private int parent(int current) {
        return current/2;
    }

    private int left(int current){
        return 2*current;
    }

    private int right(int current){
        return 2*current+1;
    }

    public int extractMin(){
        int value = heap[Front];
        heap[Front] = heap[--size];
        minHeapify(Front);
        return value;
    }

    private void minHeapify(int front) {
        // if not leaf node
        if(!isLeaf(front)){
            if(heap[front] > heap[left(front)] || heap[front] < heap[right(front)]){
                if(heap[left(front)] > heap[right(front)]){
                    swap(right(front),front);
                    minHeapify(right(front));
                }else{
                    swap(left(front),front);
                    minHeapify(left(front));
                }
            }
        }
    }

    private boolean isLeaf(int front) {
        if(front >= size/2 && front<=size){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        for (int i = 1; i <=size; i++) {
            builder.append(heap[i]+" ");
        }
        return builder.toString();
    }
}
