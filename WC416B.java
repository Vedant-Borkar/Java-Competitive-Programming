/**
 * Author: Vedant_Borkar
 * Problem:https://leetcode.com/contest/weekly-contest-416/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/
 * Name:Q3 and Q4. Count Substrings That Can Be Rearranged to Contain a String II
 */

import java.util.*;

class Sol {
    public long validSubstringCount(String word1, String word2) {
        int[] count2 = new int[26];
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }

        int[] currentCount = new int[26];
        int left = 0;
        long result = 0;
        int requiredChars = 0;

        for (int i = 0; i < 26; i++) {
            if (count2[i] > 0) requiredChars++;
        }

        for (int right = 0; right < word1.length(); right++) {
            int index = word1.charAt(right) - 'a';
            currentCount[index]++;

            if (currentCount[index] == count2[index] && count2[index] > 0) {
                requiredChars--;
            }

            while (requiredChars == 0) {
                result += word1.length() - right;

                int leftIndex = word1.charAt(left) - 'a';
                currentCount[leftIndex]--;

                if (currentCount[leftIndex] < count2[leftIndex] && count2[leftIndex] > 0) {
                    requiredChars++;
                }

                left++;
            }
        }

        // 11943a7fcf
        return result;
    }
    public static void main(String[] args) {
        Sol solution = new Sol();
        System.out.println(solution.validSubstringCount("bcca", "abc"));
        System.out.println(solution.validSubstringCount("abcabc", "abc"));
        System.out.println(solution.validSubstringCount("abcabc", "aaabc"));
    }
}