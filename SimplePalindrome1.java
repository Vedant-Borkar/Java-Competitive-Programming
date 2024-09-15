/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2005/problem/A
 * Name:A. Simple Palindrome
 */
import java.util.*;

public class SimplePalindrome1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String v = "aeiou";
        
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] res = new char[n];
            
            for (int i = 0; i < n; i++) {
                res[i] = v.charAt(i % 5);
            }

            Arrays.sort(res);
            System.out.println(new String(res));
        }
        sc.close();
    }
}
