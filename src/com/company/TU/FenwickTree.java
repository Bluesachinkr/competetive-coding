package com.company.TU;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FenwickTree {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine().trim());
            String[] a = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < a.length; i++) {
                arr[i] = Integer.parseInt(a[i]);
            }

            int size = arr.length + 1;
            FenwickTree tree = new FenwickTree(size);
            Arrays.sort(arr);
            int[] rev = new int[arr.length];
            int k = arr.length - 1;
            for (int i = 0; i < arr.length; i++) {
                rev[i] = arr[k--];
            }
            tree.constructTree(rev);

            long res = 0;
            long mod = 998244353;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    res += Math.abs((tree.getSum(j) - tree.getSum(i - 1)) % mod);
                }
            }
            System.out.println(res);
        } catch (Exception e) {
            return;
        }
    }

    private void constructTree(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            updateUtil(i, freq[i]);
        }
    }

    public void updateUtil(int index, int val) {
        if (index < 0 || index > ft.length - 1) {
            return;
        }
        index = index + 1;
        while (index < ft.length) {
            ft[index] = xor(ft[index], val);

            index += index & (-index);
        }
    }

    public int getSum(int index) {
        if (index < 0 || index > ft.length - 1) {
            return 0;
        }
        int sum = 0;
        index++;

        while (index > 0) {
            sum = xor(sum, ft[index]);

            index -= (index & (-index));
        }

        return sum;
    }

    private int[] ft;
    private int size;

    public FenwickTree(int size) {
        this.size = size;
        this.ft = new int[size];
    }

    private int xor(int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int xor = left ^ right;
            int n = xor;
            int index = 0;
            int t = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    index = t;
                }
                n >>= 1;
                t++;
            }
            return (int) Math.pow(2, index);
        }
    }

}
