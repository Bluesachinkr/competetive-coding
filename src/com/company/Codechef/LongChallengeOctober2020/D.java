package com.company.Codechef.LongChallengeOctober2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class D {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String[] a = br.readLine().trim().split(" ");
                String[] b = br.readLine().trim().split(" ");
                int x = Integer.parseInt(a[1]);
                int p = Integer.parseInt(a[2]);
                int k = Integer.parseInt(a[3]);
                int[] arr = new int[b.length];
                for (int i = 0; i < b.length; i++) {
                    arr[i] = Integer.parseInt(b[i]);
                }
                int res = solution(arr, x, p - 1, k - 1);
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int solution(int[] arr, int x, int p, int k) {
        Arrays.sort(arr);
        if (arr[p] == x) {
            return 0;
        }
        if (k >= p && arr[p] >= x) {
            int res = 0;
            for (int i = p; i >= 0; i--) {
                if (arr[i] > x) {
                    res++;
                }
            }
            return res;
        } else if (k <= p && arr[p] <= x) {
            int res = 0;
            for (int i = p; i < arr.length; i++) {
                if (arr[i] < x) {
                    res++;
                }
            }
            return res;
        } else {
            return -1;
        }
    }
}
