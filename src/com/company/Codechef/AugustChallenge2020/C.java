package com.company.Codechef.AugustChallenge2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Third {
    public static void main(String[] args){
        try{
            new Solver();
        }catch (Exception e){
            return;
        }
    }

    static class Solver {
        Solver() throws Exception {
            textCase();
        }

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        private void textCase() throws java.lang.Exception {
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- >0){
                String[] w = br.readLine().trim().split(" ");
                int chef = Integer.parseInt(w[0]);
                int rick = Integer.parseInt(w[1]);
                solution(chef,rick);
            }
        }

        private void solution(int chef, int rick) {
            int a = digits(chef);
            int b = digits(rick);
            if(a == b ||  a > b){
                System.out.print(1+" ");
                System.out.println(b);
            }else if(a < b){
                System.out.print(0+" ");
                System.out.println(a);
            }
        }

        private int digits(int number) {
            if(number == 0){
                return 0;
            }
            int res = 0;
            int index = 9;
            while (number > 0){
                if(index > number){
                    index--;
                }else{
                    int q = number/index;
                    res+=q;
                    number = number%index;
                }
            }
            return res;
        }

    }
}
