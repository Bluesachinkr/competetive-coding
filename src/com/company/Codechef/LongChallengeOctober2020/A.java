package com.company.Codechef.LongChallengeOctober2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class A {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String[] str = br.readLine().split(" ");
                int k = Integer.parseInt(str[1]);
                String[] s = br.readLine().trim().split(" ");
                int[] arr = new int[s.length];
                for (int i = 0; i < s.length; i++) {
                    arr[i] = Integer.parseInt(s[i]);
                }
                long sum = 0;
                for (int i = 0; i <arr.length ; i++) {
                    sum+=arr[i];
                    if(sum < (i+1)*k){
                        break;
                    }
                }
                System.out.println(sum/k +1);
            }
        } catch (Exception e) {
            return;
        }
    }
}
