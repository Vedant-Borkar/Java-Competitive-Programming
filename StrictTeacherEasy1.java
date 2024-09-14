/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2005/problem/B1
 * Name:B. Strict Teacher Easy
 */
import java.util.*;

public class StrictTeacherEasy1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        while (t-- > 0) {
            int n = sc.nextInt(); 
            int m = sc.nextInt(); 
            int q = sc.nextInt(); 

            int[] te = new int[m];
            for (int i = 0; i < m; i++) {
                te[i] = sc.nextInt();
            }

            int dPos = sc.nextInt();
            int mv = 0;
            int t1 = Math.min(te[0], te[1]);
            int t2 = Math.max(te[0], te[1]);

            while (dPos != t1 && dPos != t2) {
                mv++;

                if (dPos < t1) {
                    dPos = Math.max(1, dPos - 1);
                } else if (dPos > t2) {
                    dPos = Math.min(n, dPos + 1);
                } else if (dPos - t1 <= t2 - dPos) {
                    dPos = Math.min(n, dPos + 1);
                } else {
                    dPos = Math.max(1, dPos - 1);
                }

                if (t1 < dPos) {
                    t1++;
                } else if (t1 > dPos) {
                    t1--;
                }

                if (t2 < dPos) {
                    t2++;
                } else if (t2 > dPos) {
                    t2--;
                }
            }

            System.out.println(mv);
        }

        sc.close();
    }
}
