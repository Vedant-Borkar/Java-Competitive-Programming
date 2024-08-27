/**
 * Author: Vedant_Borkar
 * Problem: https://codeforces.com/contest/514/problem/A
 * Name: A. Chewbaсca and Number
 */
import java.util.*;

public class ChewbeccaNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        System.out.println(transformNumber(x));
        sc.close();
    }

    private static long transformNumber(long x) {
        char[] digits = Long.toString(x).toCharArray();
        
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i] - '0';
            int inverted = 9 - digit;
            
            if (i == 0 && inverted == 0) {
                continue; 
            }
            
            if (inverted < digit) {
                digits[i] = (char)(inverted + '0');
            }
        }
        
        return Long.parseLong(new String(digits));
    }
}