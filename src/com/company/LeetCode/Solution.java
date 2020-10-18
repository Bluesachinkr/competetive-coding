package com.company.LeetCode;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "aaabccddd";
            String res = superReducedString(str);
            System.out.println(res);
        } catch (Exception e) {
            return;
        }
    }

    static String superReducedString(String s) {
        int i = 0;
        while(true){
            if(i+1 < s.length()){
                if(s.charAt(i) == s.charAt(i+1)){
                    s = s.substring(0,i)+s.substring(i+2);
                }else{
                    i++;
                }
            }else{
                break;
            }
        }
        return s;
    }

}
