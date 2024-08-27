/**
 * Author: Vedant_Borkar
 * Problem: https://leetcode.com/problems/reverse-integer/
 * Name: 7. Reverse Integer
 */
import java.io.*;
import java.util.*;

public class ReverseIntegerLC {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0){
      int n=sc.nextInt();
      System.out.println(reverse(n));
    }
  }
  public static int reverse(int x) {
    String ans = "";
    long answer = 0;
    boolean flag = false;
    
    // Handle the case of Integer.MIN_VALUE separately
    if (x == Integer.MIN_VALUE) {
        return 0;  // Since reversed value would overflow
    }
    
    if (x < 0) {
        flag = true;
        x = -x;
    }
    while (x > 0) {
        ans = ans + (x % 10);
        x = x / 10;
    }
    if (!ans.isEmpty()) {
        answer = Long.parseLong(ans);
        if (flag) answer = -answer;
        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) answer = 0;
    }
    return (int)answer;
}
}
