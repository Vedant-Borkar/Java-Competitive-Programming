/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2003/problem/A
 * Name: A. Turtle and Good Strings
 */
import java.io.*;
import java.util.*;

public class TurtleandString {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0){
      int n=sc.nextInt();
      String s=sc.next();
      if(s.charAt(s.length()-1)==s.charAt(0)) System.out.println("NO");
      else System.out.println("YES");
    }
  }
}
