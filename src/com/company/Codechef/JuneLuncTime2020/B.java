package com.company.Codechef.JuneLuncTime2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class B {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                String[] as = br.readLine().trim().split(" ");
                int[] a = new int[n];
                for (int i = 0; i < as.length; i++) {
                    a[i] = Integer.parseInt(as[i]);
                }
                solution(a);
            }
        } catch (Exception e) {
            return;
        }
    }

    private static void solution(int[] a) {
        int[] res = new int[a.length];
        Arrays.fill(res, 0);
        Arrays.sort(a);
        boolean r = true;
        int front = 0;
        int last = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                res[front] = a[i];
                front++;
            } else {
                if (a[i] > res[front - 1]) {
                    res[front] = a[i];
                    front++;
                } else {
                    if (last == a.length - 1) {
                        res[last] = a[i];
                        last--;
                    } else {
                        if (a[i] > res[last + 1]) {
                            res[last] = a[i];
                            last--;
                        } else {
                            r = false;
                            break;
                        }
                    }
                }
            }
        }
        if (r) {
            for (int i = 1; i < res.length; i++) {
                if(res[i] == res[i-1]){
                    System.out.println("NO");
                    return;
                }
            }
                System.out.println("YES");
                for (int i = 0; i < res.length; i++) {
                    System.out.print(res[i] + " ");
                }
                System.out.println();
        }else {
            System.out.println("NO");
        }
    }
}
