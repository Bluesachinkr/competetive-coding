package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ChefAndRevenue {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String[] two = br.readLine().split(" ");
                int n = Integer.parseInt(two[0]);
                int k = Integer.parseInt(two[1]);
                String[] w = br.readLine().split(" ");
                int[] arr = new int[n];
                for (int i = 0; i < w.length; i++) {
                    arr[i] = Integer.parseInt(w[i]);
                }
                int sum = sum(arr);
                int res = solution(arr, k);
                System.out.println(sum-res);
            }
        } catch (Exception e) {
        } finally {
        }
    }

    private static int sum(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return res;
    }

    private static int solution(int[] arr, int k) {
        int res = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] > k){
                res+=k;
            }else{
                res+=arr[i];
            }
        }
        return res;
    }
}
