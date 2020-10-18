package CompetetiveCoding;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            int day = 0;
            Arrays.sort(arr);
            long cures = x;
            for (int i = 0; i < arr.length; i++) {
                while (arr[i] > cures) {
                    day++;
                    cures = cures*2;
                }
                day++;
            }
            out.println(day);
        }
    }
}
