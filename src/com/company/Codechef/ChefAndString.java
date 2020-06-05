package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ChefAndString {
    public static void main(String[] args) throws java.lang.Exception{
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                String str=br.readLine().trim();
                int res  = solution(str);
                System.out.println(res);
            }
        }catch (Exception e){
        }finally {
        }
    }

    private static int solution(String str) {
        int res = 0;
        int i = 0;
        while (i < str.length()-1) {
            if(str.charAt(i) == 'x' && str.charAt(i+1) == 'y'){
                res++;
                i+=2;
            }else if(str.charAt(i) == 'y' && str.charAt(i+1)=='x'){
                res++;
                i+=2;
            }else{
                i++;
            }
        }
        return res;
    }
}
