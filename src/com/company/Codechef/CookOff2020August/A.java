package com.company.Codechef.CookOff2020August;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class First {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
              String[] w = br.readLine().split(" ");
              int n = Integer.parseInt(w[0]);
              int k = Integer.parseInt(w[1]);
              String[] s = br.readLine().split(" ");
              int[] a = new int[n];
                for (int i = 0; i <s.length ; i++) {
                    a[i] = Integer.parseInt(s[i]);
                }
                System.out.println(result(a,k));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static long result(int[] arr, int k) {
        long res = 0;
        int temp = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] > k){
                return -1;
            }
            if((temp + arr[i]) > k){
                temp = arr[i];
                res++;
            }else{
                temp+=arr[i];
            }
        }
        return (temp > 0)?res+1:res;
    }

}
