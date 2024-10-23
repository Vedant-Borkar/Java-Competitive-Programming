/**
 * Author: Vedant_Borkar
 * Problem: https://codeforces.com/contest/2003/problem/B
 * Name: CodeChef.S157.B. Turtle and Piggy Are Playing a Game 2
 */
import java.util.*;

public class Turtlea {
    static final int maxn = 100100;
    static int n;
    static Integer[] a = new Integer[maxn];
    static Scanner sc = new Scanner(System.in);

    static void solve() {
        n = sc.nextInt();
        for (int i = 1; i <= n; ++i) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a, 1, n + 1, Collections.reverseOrder());
        System.out.println(a[(n + 1) / 2]);
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        while (T-- > 0) {
            solve();
        }
    }
}