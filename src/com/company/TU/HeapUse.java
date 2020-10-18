package com.company.TU;

import java.util.Arrays;

public class HeapUse {
    private  static int[] arr = {1,3,9,5,32,78,67,11,4};

    public static void main(String[] args) {
      heapSort(arr);
    }

    private static void prnt(){
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int[] arr){
        //build an heap
        for (int i = arr.length/2 -1; i>=0 ; i--) {
            heapify(arr,arr.length,i);
        }

        for(int i = arr.length-1;i>0;i--){
            swap(arr,0,i);
            prnt();
            heapify(arr,i,0);
        }
    }

    private static void heapify(int[] arr, int length, int i) {
        int largest = i;
        int l = 2*i +1;
        int r = 2*i +2;

        if(l < length && arr[l] > arr[largest]){
            largest = l;
        }

        if(r < length && arr[r] > arr[largest]){
            largest = r;
        }

        if(largest != i){
            swap(arr,largest,i);
            prnt();
            heapify(arr,length,largest);
        }
    }

    private static void swap(int[] arr, int largest, int i) {
        int temp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = temp;
    }

}
