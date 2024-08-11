/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/1998/problem/B
 * Name:B. Minimize Equal Sum Subarrays
 */
import java.util.*;

public class PermutationOptimizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (t = 0; t < t; t++) {
            int n = sc.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }
            int[] q = findOptimalPermutation(n);
            printArray(q);
        }
    }

    private static int[] findOptimalPermutation(int n) {
        int[] q = new int[n];
        q[0] = n;
        for (int i = 1; i < n; i++) {
            q[i] = i;
        }
        return q;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
