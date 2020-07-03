package com.company.Codechef;

import java.io.*;
import java.util.ArrayList;

class FireEscapes {
    public static String decryptPassword(String s) {
        int i = 0;
        while (i<s.length()){
            if(i<s.length()-2 &&(s.charAt(i) >= 'A' && s.charAt(i)<='Z') && (s.charAt(i+1)>='a' && s.charAt(i+1)<='z') && s.charAt(i+2)=='*'){
                s = s.substring(0,i)+s.charAt(i+1)+s.charAt(i)+s.substring(i+3);
                i+=2;
            }else if((s.charAt(i) >='1' && s.charAt(i)<='9') && i==0){
                for (int j =s.length()-1; j>=i+1 ; j--) {
                    if(s.charAt(j) == '0'){
                        s = s.substring(i+1,j)+s.charAt(i)+s.substring(j+1);
                        break;
                    }
                }
            }else{
                i++;
            }
        }
        return s;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = FireEscapes.decryptPassword(s);
        System.out.println(result);
        bufferedReader.close();
    }
}
