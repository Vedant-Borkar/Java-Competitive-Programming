/**
 * Author: Vedant_Borkar
 * Problem: https://takeuforward.org/recursion/print-1-to-n-using-recursion/
 * Name: Recursion Printing
 */
import java.util.*;
public class RecursionPrint1N1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println("Straight");
    print1N(1,n);
    System.out.println("Reverse");
    printN1(1,n);
  }

  public static void print1N(int i ,int n) {
    if(i>n) return;
    System.out.println(i);
    print1N(i+1,n);
  }

  public static void printN1(int i,int n) {
    if(i>n) return;
    System.out.println(n);
    printN1(i,n-1);
  }
}
