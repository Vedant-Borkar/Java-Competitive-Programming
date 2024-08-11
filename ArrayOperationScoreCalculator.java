/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/1998/problem/C
 * Name:C. Perform Operations to Maximize Score
 */
import java.util.*;

public class ArrayOperationScoreCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int j = 0; j < t; j++) {
            int n = sc.nextInt(); 
            int k = sc.nextInt(); 

            long[] a = new long[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            System.out.println(calculateMaxScore(a, b, k));
        }

    }

    private static long calculateMaxScore(long[] a, int[] b, int k) {
        PriorityQueue<Long> increasableElements = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 1) {
                increasableElements.offer(a[i]);
            }
        }

        for (int i = 0; i < k && !increasableElements.isEmpty(); i++) {
            long val = increasableElements.poll();
            increasableElements.offer(val + 1);
        }

        long[] updatedA = new long[a.length];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 1 && !increasableElements.isEmpty()) {
                updatedA[i] = increasableElements.poll();
            } else {
                updatedA[i] = a[i];
            }
        }

        Arrays.sort(updatedA);

        long median;
        if (updatedA.length % 2 == 0) {
            median = (updatedA[updatedA.length / 2 - 1] + updatedA[updatedA.length / 2]) / 2;
        } else {
            median = updatedA[updatedA.length / 2];
        }
        long maxScore = 0;
        for (int i = 0; i < updatedA.length; i++) {
            maxScore = Math.max(maxScore, updatedA[i] + median);
        }

        return maxScore;
    }
}