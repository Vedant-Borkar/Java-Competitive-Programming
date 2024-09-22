/**
 * Author: Vedant_Borkar
 * Problem:https://leetcode.com/contest/weekly-contest-416/problems/report-spam-message/
 * Name:Q1. Report Spam Message
 */
import java.util.*;
class Solu{
    public long minNumberOfSeconds(int mht, int[] wts) {
        long lft = 1, rgt = (long) 1e15;
        while (lft < rgt) {
            long mid = lft + (rgt - lft) / 2;
            if (can(mid, mht, wts)) {
                rgt = mid;
            } else {
                lft = mid + 1;
            }
        }
        return lft;
    }

    private boolean can(long tme, int mht, int[] wts) {
        long ttl = 0;
        for (int wtm : wts) {
            long hgt = (long) ((-1 + Math.sqrt(1 + 8.0 * tme / wtm)) / 2);
            ttl += hgt;
            if (ttl >= mht) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solu solu = new Solu();

        // Example 1
        System.out.println(solu.minNumberOfSeconds(4, new int[]{2, 1, 1})); // Expected output: 3

        // Example 2
        System.out.println(solu.minNumberOfSeconds(10, new int[]{3, 2, 2, 4})); // Expected output: 12

        // Example 3
        System.out.println(solu.minNumberOfSeconds(5,new int[]{1})); // Expected output: 15
    }
}