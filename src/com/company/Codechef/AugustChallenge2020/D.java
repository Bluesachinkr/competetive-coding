package com.company.Codechef.AugustChallenge2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
class D {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String str = br.readLine().trim();
                String pattern = br.readLine().trim();
                String res = solution(str, pattern);
                System.out.println(res);
            }
        } catch (Exception e) {
            return;
        }
    }
    private static String solution(String s, String p) {
        if (s.length() == 1) {
            return p;
        }
        if (s.length() == p.length()) {
            return p;
        }
        int str[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            str[index]++;
        }
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            int index = ch - 'a';
            str[index]--;
        }
        int l = p.charAt(0) - 'a';
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < l; i++) {
            char ch = (char) (i + 'a');
            while (str[i]-- > 0) {
                res.append(ch);
            }
        }
        char sameChar = (char) (l + 'a');
        if (p.length() > 1) {
            int i = 0;
            while (p.charAt(i) == sameChar) {
                i++;
            }
            if (p.charAt(i) > sameChar) {
                while (str[l]-- > 0) {
                    res.append(sameChar);
                }
                res.append(p);
            } else {
                res.append(p);
                while (str[l]-- > 0) {
                    res.append(sameChar);
                }
            }
        } else {
            while (str[l]-- > 0) {
                res.append(sameChar);
            }
            res.append(p);
        }
        for (int i = l; i < str.length; i++) {
            while (str[i]-- > 0) {
                char ch = (char) ('a' + i);
                res.append(ch);
            }
        }

        return res.toString();
    }
}
