package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

class CovidSampling {
    static class FastReader {
        BufferedReader br;

        private FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String readLine() throws java.lang.Exception {
            return br.readLine().trim();
        }
    }

    static FastReader reader = new FastReader();

    public static void main(String[] args) throws java.lang.Exception {
        try {
            int t = Integer.parseInt(reader.readLine());
            while (t-- > 0) {
                String w[] = reader.readLine().trim().split(" ");
                int n = Integer.parseInt(w[0]);
                int p = Integer.parseInt(w[1]);
                int[][] box = new int[n + 1][n + 1];
                print(1, 1, box.length - 1, box.length - 1);
                int total = Integer.parseInt(reader.readLine().trim());
                for (int i = 1; i < box.length; i++) {
                    binarySearch(box, i, box.length - 1, i, 0, p);
                }
                display(box);
                int res = Integer.parseInt(reader.readLine().trim());
                if (res == -1) {
                    break;
                }
            }
        } catch (Exception e) {

        } finally {

        }
    }

    static void print(int i, int j, int k, int l) {
        System.out.println(1 + " " + i + " " + j + " " + k + " " + l);
        System.out.flush();
    }

    static int binarySearch(int[][] box, int low, int high, int i, int count, int p) throws java.lang.Exception {
        if (low == high) {
            System.out.println(1 + " " + i + " " + low + " " + i + " " + high);
            System.out.flush();
            int total = Integer.parseInt(reader.readLine().trim());
            if (total == -1) {
                return 0;
            } else {
                return total;
            }
        }
        System.out.println(1 + " " + i + " " + low + " " + i + " " + high);
        System.out.flush();
        int total = Integer.parseInt(reader.readLine().trim());
        if (count == total) {
            randomPut(box, low, high, i, count, p);
        }
        if (total == -1) {
            return 0;
        } else {
            int mid = low + ((high - low) / 2);
            int left = binarySearch(box, low, mid, i, total, p);
            int right = binarySearch(box, mid + 1, high, i, total, p);
            return left + right;
        }
    }

    static void randomPut(int[][] box, int low, int high, int i, int count, int p) {
        int r = 100 / p;
        int k = p / (100 - p);
        for (int j = low; j <= high; j++) {

        }
    }

    static void display(int[][] a) {
        System.out.println(2);
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
