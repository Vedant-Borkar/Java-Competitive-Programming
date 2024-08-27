/**
 * Author: Vedant_Borkar
 * Problem: https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/1
 * Name: LCM and GCD
 */
import java.io.*;
import java.util.*;

class GCDLCM {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}
class Solution {
  static Long[] lcmAndGcd(Long A , Long B) {
      // code here
      Long[] arr = new Long[2];
      long gcd = 1;
      for(long i = Math.min(A, B); i > 0; i--) {
          if(A % i == 0 && B % i == 0) {
              gcd = i;
              break;
          }
      }
      arr[0] = gcd;
      arr[1] = (A * B) / gcd;
      return arr;
  }
}