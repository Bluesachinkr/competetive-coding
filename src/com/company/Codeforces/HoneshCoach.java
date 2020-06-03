package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HoneshCoach {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String[] arrS =br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i <arrS.length ; i++) {
                arr[i] = Integer.parseInt(arrS[i]);
            }
            int res = solution(arr);
            System.out.println(res);
        }
    }

    private static int solution(int[] arr) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i <arr.length ; i++) {
            res = Math.min(res,arr[i]-arr[i-1]);
        }
        return res;
    }
}
