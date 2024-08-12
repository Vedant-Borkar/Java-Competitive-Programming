/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/1997/problem/A
 * Name:A. Strong Password
 */
import java.util.*;
import java.io.*;
public class strongpass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            int count = 0;
            StringBuilder str = new StringBuilder();
            char[] ch = s.toCharArray();
            if (n == 1) {
                str.append(s);
                str.append(s.charAt(0) == 'z' ? 'a' : (char)(s.charAt(0) + 1));
            } else {
                for (int i = 0; i < n - 1; i++) {
                    str.append(ch[i]);
                    if (ch[i] == ch[i+1] && count == 0) {
                        str.append(ch[i] == 'z' ? 'a' : (char)(ch[i] + 1));
                        count++;
                    }
                }
                str.append(s.charAt(n - 1));
                if (count == 0) {
                    str.append(s.charAt(n - 1) == 'z' ? 'a' : (char)(s.charAt(n - 1) + 1));
                }
            }
            System.out.println(str);
        }
    }
}