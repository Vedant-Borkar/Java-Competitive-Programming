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
            int prev = 0, next = n + 1;

            for (int tchr : te) {
                if (tchr < dPos && tchr > prev) {
                    prev = tchr;
                }
                if (tchr > dPos && tchr < next) {
                    next = tchr;
                }
            }

            int optPos = (next + prev) / 2;
            int mv = Math.max(optPos - prev, next - optPos);

            if (prev == 0) {
                mv = Math.min(mv, dPos - 1);
            }
            if (next == n + 1) {
                mv = Math.min(mv, n - dPos);
            }

            System.out.println(mv);
        }

        sc.close();
    }
}
