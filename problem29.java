/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/1998/problem/B
 * Name:B. Minimize Equal Sum Subarrays
 */
import java.util.*;

public class problem29{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        for (long j = 0; j < t; j++) {
            int n = sc.nextInt();
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextLong();
            }
            long[] q = findOptimalPermutation(p);
            printArray(q);
        }
        sc.close();
    }

    private static long[] findOptimalPermutation(long[] p) {
        int n = p.length;
        long[] q = new long[n];
        q[0] = p[n-1];
        for (int i = 1; i < n; i++) {
            q[i] = p[i-1];
        }
        return q;
    }

    private static void printArray(long[] arr) {
        for (long num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}