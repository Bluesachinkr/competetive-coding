package com.company.Codechef.AugustChallenge2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Sixth {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                String[] w = br.readLine().trim().split(" ");
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(w[i]);
                }
                solution(arr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solution(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(result(2,arr.length-1,1000000007)+" ");
        }
        System.out.println();
    }

    private static long result(long x,long y,long p){
        long res = 1;
        x = x%p;
        if(x == 0){
            return p;
        }
        while (y > 0){
            if(y > 1){
                res = (res*x)%p;
                return res;
            }
        }
        return  res;
    }
}
