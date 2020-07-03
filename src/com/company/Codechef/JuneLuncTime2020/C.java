package com.company.Codechef.JuneLuncTime2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class C {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                String[] w = br.readLine().split(" ");
                String[] w1 = br.readLine().trim().split(" ");
                int n = Integer.parseInt(w[0]);
                int k = Integer.parseInt(w[1]);
                int[] a =new int[n];
                for (int i = 0; i <w1.length ; i++) {
                    a[i] = Integer.parseInt(w1[i]);
                }
                int res = solution(k,a);
                System.out.println(res);
            }
        }catch (Exception e){
            return;
        }
    }

    static int countOne(int n){
        int cnt= 0;
        while (n > 0){
            cnt+=(n&1);
            n>>=1;
        }
        return cnt;
    }


    static int number(int k){
        int res = 0;
        for (int i = 0; i <k ; i++) {
            res+=Math.pow(2,i);
        }
        return res;
    }

    private static int solution(int k, int[] a) {
        int max = -1;
        for (int i = 0; i <a.length ; i++) {
            if(a[i] > max){
                max = a[i];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int x = -1;
        int s = number(k);
        for (int i = s; i <=max ; i++) {
            if(countOne(i) == k){
                int sum = 0;
                for (int j = 0; j <a.length ; j++) {
                    sum += (i&a[j]);
                }
                if(sum > maxSum){
                    maxSum = sum;
                    x = i;
                }
            }
        }
        return x;
    }
}
