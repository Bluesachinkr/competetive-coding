package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TroubleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String[] a1 = br.readLine().trim().split(" ");
        String[] b1 = br.readLine().trim().split(" ");
        int[] a =new int[n];
        int[] b=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i] = Integer.parseInt(a1[i]);
            b[i] = Integer.parseInt(b1[i]);
        }
        boolean res = solution(a,b,0);
        if(res){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    private static boolean solution(int[] a, int[] b,int i) {
        if(i >= a.length){
            return true;
        }
            while(i < a.length) {
                for (int j = i + 1; j < b.length; j++) {
                    if ((b[i] != b[j]) && (a[i] > a[j])) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        if(!solution(a,b,j)){
                            return false;
                        }
                    }

                }
                i++;
            }
            int m = a[0];
            for (int k = 1;k < a.length; k++) {
                if (a[k] < m) {
                    return false;
                }
            }
        return true;
    }
}
