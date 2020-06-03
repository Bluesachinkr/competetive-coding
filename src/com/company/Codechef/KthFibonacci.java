package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KthFibonacci {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String[] words = br.readLine().split(" ");
            int n = Integer.parseInt(words[0]);
            int k = Integer.parseInt(words[1]);
            long res = solution(n,k);
            System.out.println(res);
        }catch (Exception e){
        }finally {
        }
    }

    private static long solution(int n, int k) {
       long arr[] =new long[n+1];
        for (int i = 1; i <arr.length ; i++) {
            if(i<=k){
                arr[i]=1;
            }else{
                long sum = 0;
                for (int j =i-k; j < i ; j++) {
                    if(j >=0) {
                        sum += arr[j];
                    }
                }
                arr[i]=sum;
                arr[i]%=1000000007;
            }
        }
        return arr[n];
    }
}
