package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemoveSmallest {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            input(br);
        }
    }

    private static void input(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String[] s2 = br.readLine().split(" ");
        int[] b = new int[n];
        for (int i = 0; i <n ; i++) {
            b[i] = Integer.parseInt(s2[i]);
        }
        long res = solution(b);
        System.out.println((res == 1)?"YES":"NO");
    }

    private static long solution(int[] b) {
        int size = 0;
        Arrays.sort(b);
        for (int i = 0; i <b.length-1 ; i++) {
            for (int j = i+1; j <b.length; j++) {
                if(Math.abs(b[i]-b[j])<=1){
                    size++;
                    break;
                }
            }
        }
        return b.length-size;
    }
}
