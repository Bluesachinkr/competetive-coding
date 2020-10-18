package com.company.Codeforces.VirtualCodeforces.context1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
    public static void main(String[] args) throws IOException {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while (t-- > 0){
                String[] s = br.readLine().trim().split(" ");
                String[] st = br.readLine().split(" ");
                int n = Integer.parseInt(s[0]);
                int current = Integer.parseInt(s[1]);
                int k = Integer.parseInt(s[2]);
                int[] a = new int[k];
                for (int i = 0; i <st.length ; i++) {
                    a[i] = Integer.parseInt(st[i]);
                }
                int res = solution(current,a);
                System.out.println(res);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static int solution(int current, int[] a) {
        Arrays.sort(a);
        int pos = search(a,current);
        if(pos == -1){
            return 0;
        }else {
            int prev = 0;
            int next = current;
            for (int i = 0; i <a.length ; i++) {
                if(a[i] < current){
                    if(prev != a[i]-1){
                        prev = a[i]-1;
                    }
                }else if(a[i] > current){
                    if(next+1 != a[i]){
                        next = next+1;
                        break;
                    }
                }else{
                    if(prev != 0 && prev != a[i]-1){
                        prev = a[i]-1;
                    }
                }
            }
            if(prev == 0 && next == current){
                return Math.abs((a[a.length-1]+1)-current);
            }else {
                return Math.min(Math.abs(current - next), Math.abs(current - prev));
            }
        }
    }

    private static int search(int[] a,int current){
        int low = 0;
        int high = a.length-1;
        while (low <=high){
            int  mid = low+((high-low)/2);
            if(a[mid] == current){
                return mid;
            }else if(a[mid]>current){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
