package com.company.Codechef.CodeAssemble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class B {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String str = br.readLine().trim();
                String[] s1 = br.readLine().split(" ");
                int x = Integer.parseInt(s1[0]);
                int y = Integer.parseInt(s1[1]);
                int q = Integer.parseInt(br.readLine().trim());
                int[][] arr = new int[q][2];
                for (int i = 0; i < q; i++) {
                    String[] k = br.readLine().trim().split(" ");
                    arr[i][0] = Integer.parseInt(k[0]);
                    arr[i][1] = Integer.parseInt(k[1]);
                }
                result(str, x, y, arr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void result(String str,int x,int y,int[][]arr){
        HashMap<Character,Long> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            long l = 0;
            count.put(c, count.getOrDefault(c, l) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            int finalx = arr[i][0];
            int finaly = arr[i][1];
            int res = 0;
            if(finalx == x && finaly==y){
                System.out.println("YES"+" "+res);
            }else{
                if(finalx != x){
                    long d = 0;
                    long cnt = 0;
                    if(finalx > x){
                        d = finalx-x;
                        cnt = count.get('R');
                    }else{
                        d = x -finalx;
                        cnt = count.get('L');
                    }
                    if(cnt >=d){
                        res+=d;
                    }
                }
                if(finaly !=y){
                    long d = 0;
                    long cnt = 0;
                    if(finaly > y){
                        d = finaly-y;
                        cnt = count.get('U');
                    }else{
                        d = y - finaly;
                        cnt = count.get('D');
                    }
                    if(cnt >=d){
                        res+=d;
                    }
                }
                if(res == 0){
                    System.out.println("NO");
                }else{
                    System.out.println("YES"+" "+res);
                }
            }
        }
    }

    private static void solution(String str, int x, int y, int[][] arr) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            int finalx = arr[i][0];
            int finaly = arr[i][1];
            if (finalx == x && finaly == y) {
                System.out.println("YES" + " " + 0);
            } else {
                int res = 0;
                if(finalx == x){

                }else if (finalx > x) {
                    int d = finalx - x;
                    int cnt = count.get('R');
                    if (cnt >= d) {
                        res += d;
                    } else {
                        System.out.println("NO");
                        continue;
                    }
                } else {
                    int d = x - finalx;
                        int cnt = count.get('L');
                    if (cnt >= d) {
                        res += d;
                    } else {
                        System.out.println("NO");
                        continue;
                    }
                }

                if(finaly == y){

                }else if (finaly > y) {
                    int d = finaly - y;
                    int cnt = count.get('U');
                    if (cnt >= d) {
                        res += d;
                    } else {
                        System.out.println("NO");
                        continue;
                    }
                } else {
                    int d = y - finaly;
                    int cnt = count.get('D');
                    if (cnt >= d) {
                        res += d;
                    } else {
                        System.out.println("NO");
                        continue;
                    }
                }
                System.out.println("YES" + " " + res);
            }
        }
    }
}
