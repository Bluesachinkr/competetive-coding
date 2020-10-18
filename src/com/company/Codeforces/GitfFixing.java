package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitfFixing {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            input(br);
        }
    }

    private static void input(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i <n ; i++) {
            a[i] = Integer.parseInt(s1[i]);
            b[i] = Integer.parseInt(s2[i]);
        }
        long res = solution(a,b);
        System.out.println(res);
    }

    private static long solution(int[] a, int[] b) {
       int min = Integer.MAX_VALUE;
        for (int i = 0; i <a.length ; i++) {
            if(a[i] < min){
                min = a[i];
            }
        }
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i <b.length ; i++) {
            if(b[i] < min2){
                min2 = b[i];
            }
        }
        long res = 0;
        for (int i = 0; i <a.length ; i++) {
            if(a[i] > min && b[i]>min2){
                int ac = Math.abs(a[i]-min);
                int bc = Math.abs(b[i]-min2);
                res+= Math.max(ac,bc);
            }else {
                if(a[i] > min){
                    res+=Math.abs(a[i]-min);
                }
                if(b[i] > min2){
                    res+=Math.abs(b[i]-min2);
                }
            }
        }
        return res;
    }
}
