package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class CodeChef {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String[] a = br.readLine().trim().split(" ");
                String[] b = br.readLine().trim().split(" ");
                String[] c = br.readLine().trim().split(" ");
                int n = Integer.parseInt(a[0]);
                int k = Integer.parseInt(a[1]);
                long[] arr = new long[n];
                long[] brr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(b[i]);
                    brr[i] = Integer.parseInt(c[i]);
                }
                long res = solution(k, arr, brr);
                System.out.println(res);
            }
        } catch (Exception e) {
            return;
        }
    }

    private static long solution(int k, long[] arr, long[] brr) {
        long res = Long.
                MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] += k;
            res = Math.max(res, interactions(arr, brr));
            arr[i] -= k;

            arr[i] -= k;
            res = Math.max(res, interactions(arr, brr));
            arr[i] += k;
        }
        return res;
    }

    private static long interactions(long[] arr, long[] brr) {
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] * brr[i];
        }
        return res;
    }
}
