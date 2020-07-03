package com.company.Codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class GuessingGame{

    static class FastReader{
        BufferedReader br;
        private FastReader(){
            br= new BufferedReader(new InputStreamReader(System.in));
        }
        public String readLine() throws java.lang.Exception{
            return br.readLine().trim();
        }
    }

    static FastReader reader = new FastReader();

    public static void main(String[] args) throws java.lang.Exception {
        try {
            int n = Integer.parseInt(reader.readLine());
            int L = 1;
            int R = n;
            int nextY = 0;
            int predict = predict(L,R);
            boolean nextlie = false;
            if(predict != 2){
                if(predict == 1){
                    nextlie = true;
                }
                while (L <= R) {
                    int y = L + ((R - L) / 2);
                    if (nextY > 0) {
                        y = nextY;
                    }
                    System.out.println(y);
                    System.out.flush();
                    String c = reader.readLine();
                    if (c.equals("G")) {
                        if (nextlie) {
                            nextY = L + (((y-1)-L)/2);
                            nextlie = false;
                        } else {
                            nextY = 0;
                            L = y + 1;
                            nextlie = true;
                        }
                    } else if (c.equals("L")) {
                        if (nextlie) {
                            nextY = (y+1) + ((R-(y+1))/2);
                            nextlie = false;
                        } else {
                            nextY = 0;
                            R = y - 1;
                            nextlie = true;
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e) {

        } finally {

        }
    }

    static int  predict(int L ,int R) throws java.lang.Exception{
        try{
            int nextY = 0;
            boolean nextlie = false;
            int low = L;
            int high = R;
            String move = "";
            while (L <= R) {
                int y = L + ((R - L) / 2);
                if (nextY > 0) {
                    y = nextY;
                }
                if(move.length() == 2){
                    if (move.charAt(move.length()-1) == 'G'){
                        y = L;
                    }else {
                        y = R;
                    }
                }
                System.out.println(y);
                System.out.flush();
                String c = reader.readLine();
                if (move.length() ==2 && !c.equals("E") ) {
                    if(move.charAt(move.length()-1) == move.charAt(move.length()-2)){
                        if (move.charAt(move.length()-1) == c.charAt(0)){
                            return 0;
                        }else{
                            return 1;
                        }
                    }else{
                        if (move.charAt(move.length()-1) == c.charAt(0)){
                            return 0;
                        }else {
                            return 1;
                        }
                    }
                }else {
                    if (c.equals("G")) {
                        if (move.length() == 0) {
                            R = y - 1;
                            move += c;
                        } else{
                            L = y + 1;
                            move += c;
                        }
                    } else if (c.equals("L")) {
                        if (move.length() == 0) {
                            L = y + 1;
                            move += c;
                        } else{
                            R = y - 1;
                            move += "L";
                        }
                    } else {
                        return 2;
                    }
                }
            }
        }catch (Exception e){
        }finally {
        }
        return -1;
    }
}
