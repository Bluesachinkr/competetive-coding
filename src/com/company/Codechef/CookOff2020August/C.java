package com.company.Codechef.CookOff2020August;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Third {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                for (int i = 0; i < n; i++) {
                    String[] s = br.readLine().split(" ");
                }
                long res = n;
                while (n / 2 >= 3) {
                    res += n / 2;
                    n /= 2;
                }
                System.out.println(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
