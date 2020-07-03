package com.company.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0){
            String str[]=br.readLine().trim().split(" ");
            int n =Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            String s=br.readLine().trim();
            int res= solution(s,n,k);
            System.out.println(res);
        }
    }

    static int solution(String s, int n, int k) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if(s.charAt(i)=='0'){
               boolean done = true;
                for (int j = i-1 ; j>=i-k && j>=0; j--) {
                    if(s.charAt(j)=='1') {
                        done = false;
                        break;
                    }
                }
                if(done) {
                    for (int j = i+1; j <=i+k && j<s.length(); j++) {
                        if(s.charAt(j)=='1') {
                            done = false;
                            break;
                        }
                    }
                }
                if(!done) {
                    i++;
                }else {
                    res++;
                    i = i+k+1;
                }
            }else{
                boolean done = true;
                for(int j = i+1;j<=i+k && j<s.length();j++){
                    if(s.charAt(j) == '1'){
                        done = false;
                        break;
                    }
                }
                if(done){
                    for (int j = i+k+2; j <=(i+k+k+1)  && j<s.length(); j++) {
                        if(s.charAt(j)=='1'){
                            done = false;
                            break;
                        }
                    }
                }
                if (done){
                    res++;
                    i = i+k+k+2;
                }else{
                    i++;
                }
            }
        }
        return res;
    }
}
