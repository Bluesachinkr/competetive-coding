package com.company.Codechef.CookOffJune2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class A {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                String[] w = br.readLine().trim().split(" ");
                int n = Integer.parseInt(w[0]);
                int b = Integer.parseInt(w[1]);
                int m = Integer.parseInt(w[2]);
                String[] strarr = br.readLine().trim().split(" ");
                int[] arr=new int[strarr.length];
                for (int i = 0; i <strarr.length ; i++) {
                    arr[i] =Integer.parseInt(strarr[i]);
                }
                int res  = solution(n,b,arr);
                System.out.println(res);
            }
        }catch (Exception e){
            return;
        }
    }

    private static int solution(int n, int b, int[] arr) {
        if(n==0 || arr.length==0){
            return 0;
        }
        int cache = -1;
        int res = 0;
        int total = (n/b)+1;
        for (int i = 0; i <arr.length ; i++) {
            int q = arr[i]/b;
            if(cache != q && cache<total){
                cache = q;
                res++;
            }
        }
        return res;
    }
}
