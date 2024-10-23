/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2005/problem/A
 * Name:CodeChef.S157.A. Simple Palindrome
 */
import java.io.*;
import java.util.*;

public class SimplePalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
        int n=sc.nextInt();
        String s="aeiou",ans="";
        if(n<=5){
            System.out.println(s.substring(0,n));
        }else{
          ans+=s.substring(0,2);
          while((n-5)>0){
            ans+="i";
            n--;
          }
          ans+=s.substring(2,5);
        System.out.println(ans);
      }
    }
  }
}
