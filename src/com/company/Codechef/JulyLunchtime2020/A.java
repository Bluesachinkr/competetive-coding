package com.company.Codechef.JulyLunchtime2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class A {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0){
                String s1[] = br.readLine().trim().split(" ");
                String[] s2 = br.readLine().split(" ");
                int n = Integer.parseInt(s1[0]);
                int k = Integer.parseInt(s1[1]);
                int[] arr = new int[n];
                for (int i = 0; i <s2.length; i++) {
                    arr[i] = Integer.parseInt(s2[i]);
                }
                String res = solution(arr,k);
                System.out.println(res);
            }
        }catch (Exception e){
            return;
        }
    }

    private static String solution(int[] arr, int k) {
        StringBuffer s = new StringBuffer("");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%k == 0){
                s.append("1");
            }else{
                s.append("0");
            }
        }
        return s.toString();
    }
}
