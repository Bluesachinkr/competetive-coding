package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ChefAndIcecream {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                String[] w = br.readLine().trim().split(" ");
                int[] arr = new int[n];
                for (int i = 0; i < w.length; i++) {
                    arr[i] = Integer.parseInt(w[i]);
                }
                String res = solution(arr);
                System.out.println(res);
            }
        } catch (Exception e) {
        } finally {
        }
    }

    private static String solution(int[] arr) {
        int total = 0;
        int change[] = new int[3];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                total += 5;
                change[0]++;
            } else {
                if (arr[i] - 5 > total) {
                    return "NO";
                } else {
                    arr[i] -= 5;
                    if (arr[i] == 10 && change[1] > 0) {
                        change[2]++;
                        change[1]--;
                    } else if (arr[i] == 5 && change[0] > 0) {
                        change[0]--;
                        change[1]++;
                    } else {
                        if (change[0] >= 2) {
                            change[2]++;
                            change[0] -= 2;
                        } else {
                            return "NO";
                        }
                    }
                    total += 5;
                }
            }
        }
        return "YES";
    }
}
