package com.company.Codechef.practise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Probelm {
    public static void main(String[] args){
        solve();
    }

    private static void solve() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- >0){
                String[] s1 = br.readLine().trim().split(" ");
                int n = Integer.parseInt(s1[0]);
                int k = Integer.parseInt(s1[1]);
                String[] s2 = br.readLine().trim().split(" ");
                int[] arr = new int[n];
                for (int i = 0; i <n ; i++) {
                    arr[i] = Integer.parseInt(s2[i]);
                }
                Arrays.sort(arr);
                long sum = 0;
                for (int i = 0; i <k ; i++) {
                    sum+=arr[i];
                }
                long sum2 = 0;
                for (int i = k; i <arr.length ; i++) {
                    sum2+=arr[i];
                }
                
                System.out.println(Math.abs(sum2-sum));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
