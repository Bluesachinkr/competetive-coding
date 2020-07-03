package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class MaximumIncrease {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine().trim());
            String[] str=br.readLine().trim().split(" ");
            int[] a=new int[n];
            for (int i = 0; i <str.length ; i++) {
                a[i]  = Integer.parseInt(str[i]);
            }
            int res = solution(a);
            System.out.println(res);
        }catch (Exception e){
            return;
        }
    }

    private static int solution(int[] a) {
        int[] dp=new int[a.length+1];
        Arrays.fill(dp,0);
        int max = Integer.MIN_VALUE;
        int len = 1;
        for (int i = 1; i <a.length ; i++) {
            if(a[i] > a[i-1]){
                len++;
            }else{
                if(max < len){
                    max = len;
                }
                len = 1;
            }
        }
        if(max < len){
            max = len;
        }
        return max;
    }
}
