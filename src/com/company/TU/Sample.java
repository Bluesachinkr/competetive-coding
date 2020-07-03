package com.company.TU;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sample {
    public static void main(String[] args) {
        String s = "aaabbbccfffgyhi";
        int c = (int)('a');
        Map<Character,Integer> map=new HashMap<>();
        Set<Integer> isVisited = new HashSet<>();
        /*for(Map.Entry<Character,Integer> mp : map.entrySet()){

        }*/
    }

    static void fre(String s){
        int[] fre = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            fre[s.charAt(i)-'a']++;
        }
        for (int i = 0; i <fre.length ; i++) {
            if(fre[i]>0) {
                char c = (char) ('a' + i);
                System.out.println(c + " " + fre[i]);
            }
        }
    }
}
