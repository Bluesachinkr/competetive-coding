package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CompetetiveTemplate {
    private BufferedReader br;
     CompetetiveTemplate(){
         br = new BufferedReader(new InputStreamReader(System.in));
     }

     public int getInt() throws IOException {
         return Integer.parseInt(br.readLine().trim());
     }

     public String getString() throws IOException{
         return br.readLine().toString();
     }

     public int[] getIntArray() throws IOException{
         String w[] = br.readLine().trim().split(" ");
         int[] arr = new int[w.length];
         for (int i = 0; i <w.length ; i++) {
             arr[i] = Integer.parseInt(w[i]);
         }
         return arr;
     }
}
