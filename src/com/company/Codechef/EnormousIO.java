package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class EnormousIO {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                solution(n);
            }
        } catch (Exception e) {
        } finally {
        }
    }

    private static void solution(int n) {
        String[][] s = new String[8][8];
        for (int i = 0; i <s.length; i++) {
            for (int j = 0; j <s[i].length ; j++) {
                s[i][j] = "";
            }
        }
        for (int k = 0; k < s.length; k++) {
            if (k == 0) {
                s[k][k] = "O";
                n--;
            } else {
                int i = 0;
                int j = k;
                while (i<= k) {
                    if (n > 0) {
                        s[i][k] = ".";
                        n--;
                    } else {
                        if(s[i][k - 1] == ""){
                            if(s[i-1][k-1] == "." || s[i-1][k-1] == "O"){
                                s[i][k] = "X";
                            }else{
                                s[i][k] = "*";
                            }
                        }else{
                            if(s[i][k-1] == "X" || s[i][k-1]=="*"){
                                if(i >=1){
                                    if(s[i-1][k-1] == "X" || s[i-1][k-1] == "*"){
                                     s[i][k] = "*";
                                    }else {
                                        s[i][k] = "X";
                                    }
                                }else{
                                    s[i][k] = "*";
                                }
                            }else{
                                s[i][k] = "X";
                            }
                        }
                    }
                    i++;
                }
                j--;
                while (j>= 0) {
                    if (n > 0) {
                        s[k][j] = ".";
                        n--;
                    } else {
                        if(s[k-1][j].equals("X") || s[k-1][j] == "*"){
                            if(s[k-1][j+1].equals("X") || s[k-1][j+1].equals("*")){
                                s[k][j] = "*";
                            }else{
                                s[k][j] = "X";
                            }
                        }else{
                            s[k][j] = "X";
                        }
                    }
                    j--;
                }
            }
        }
        for (int i = 0; i <s.length ; i++) {
            for (int j = 0; j <s[i].length ; j++) {
                if(s[i][j] == "*"){
                    System.out.print(".");
                }else {
                    System.out.print(s[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
