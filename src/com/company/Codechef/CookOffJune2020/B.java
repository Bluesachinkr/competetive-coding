package com.company.Codechef.CookOffJune2020;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class B {
    public static void main(String[] args) throws java.lang.Exception {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                String[] w = br.readLine().trim().split(" ");
                int n = Integer.parseInt(w[0]);
                int m = Integer.parseInt(w[1]);
                String[] strArr = br.readLine().trim().split(" ");
                int a[] = new int[n];
                for (int i = 0; i <strArr.length ; i++) {
                    a[i] = Integer.parseInt(strArr[i]);
                }
                int res = solution(a,m);
                System.out.println(res);
            }
        }catch (Exception e){
            return;
        }
    }

    private static int solution(int[] a, int m) {
        if(a.length == 0){
            return -1;
        }else {
            int res =0;
            Set<Integer> s=new HashSet<>();
            for (int i = 0; i <a.length ; i++) {
                if(a[i]==m){
                    res++;
                }
                if(a[i]<m){
                    s.add(a[i]);
                }
            }
            return (s.size() == m-1)? a.length-res:-1;
        }
    }
}
