package com.company.TU;

public class MaxHeap {
    private final int FRONT = 1;
    private int[] heap;
    private int current;
    private int size;

    public MaxHeap(int maxSize) {
        this.heap = new int[maxSize];
        this.current = 0;
        this.size = 0;
        this.heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int left(int pos) {
        return 2 * pos;
    }

    private int right(int pos) {
        return 2 * pos + 1;
    }

    private void swap(int one, int two) {
        int temp = heap[one];
        heap[one] = heap[two];
        heap[two] = temp;
    }

    private Boolean isLeaf(int front){
        if(front >= size/2 && front<=size){
            return true;
        }
        return false;
    }

    public void insert(int data) {
        heap[++size] = data;
        this.current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            this.current = parent(current);
        }
    }

    public int extractMax(){
        int value = heap[FRONT];
        heap[FRONT] = heap[--size];
        maxHeapify(FRONT);
        return value;
    }

    private void maxHeapify(int front) {
        if(!isLeaf(front)){
            if(heap[front] < heap[left(front)] || heap[front] < heap[right(front)]){
                if(heap[left(front)] < heap[right(front)]){
                    swap(right(front),front);
                    maxHeapify(right(front));
                }else{
                    swap(left(front),front);
                    maxHeapify(left(front));
                }
            }
        }
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
