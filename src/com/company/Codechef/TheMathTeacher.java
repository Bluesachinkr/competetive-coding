package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TheMathTeacher {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                String str = br.readLine().trim();
                long initialSize = size(str);
                String transformed = solution(str);
                long finalsize = size(transformed);
                System.out.println(initialSize-finalsize);
            }
        } catch (Exception e) {
        } finally {
        }
    }

    private static long size(String str) {
        long size = 0;
        for (int i = 0; i <str.length() ; i++) {
            if((str.charAt(i)>='a') && (str.charAt(i) <='z')){
                size+=8;
            }else{
                size+=32;
            }
        }
        return size;
    }

    private static String solution(String str) {
        StringBuilder  st = new StringBuilder("");
        Character c = 'A';
        int count = 0;
        for (int i = 0; i <str.length(); i++) {
            if((str.charAt(i) == c)){
                count++;
            }else{
                if(count==0){
                    c = str.charAt(i);
                    count++;
                }else{
                    st.append(c);
                    st.append(count);
                    count=1;
                    c = str.charAt(i);
                }
            }
        }
        return st.toString();
    }

}
