package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class PalindromicSubstrings {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String a = br.readLine().trim();
                String b = br.readLine().trim();
                boolean isPalindrome = false;
                for (int i = 0; i < a.length(); i++) {
                    for (int j = b.length() - 1; j >= 0; j--) {
                        if (a.charAt(i) == b.charAt(j)) {
                            isPalindrome = true;
                            break;
                        }
                    }
                }
                System.out.println((isPalindrome)?"Yes":"No");
            }
        } catch (Exception e) {
            return;
        }
    }
}
