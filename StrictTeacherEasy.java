/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2005/problem/B1
 * Name:B. Strict Teacher Easy
 */
import java.util.*;

public class StrictTeacherEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) a[i] = sc.nextInt();
            Arrays.sort(a);

            for (int i = 0; i < q; i++) {
                int d = sc.nextInt();
                if (Arrays.binarySearch(a, d) >= 0) {
                    System.out.println(0);
                    continue;
                }
                if (d < a[0]) {
                    System.out.println(a[0] - 1);
                    continue;
                }
                if (d > a[m - 1]) {
                    System.out.println(n - a[m - 1]);
                    continue;
                }
                int l = 0, r = m - 1;
                while (r - l > 1) {
                    int mid = (l + r) / 2;
                    if (a[mid] < d) l = mid;
                    else r = mid;
                }
                System.out.println((a[r] - a[l]) / 2);
            }
        }
        sc.close();
    }
}
