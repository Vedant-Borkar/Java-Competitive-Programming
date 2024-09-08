/**
 * Author: Vedant_Borkar
 * Problem: https://takeuforward.org/data-structure/reverse-a-given-array/
 * Name: Space Optimized Reverse Array Printing
 */
import java.util.*;
public class ArrayReverseRecursion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++) {
      arr[i] = sc.nextInt();
    }
    arr=reverse(arr,0,n-1);
    for(int i=0;i<n;i++) {
      System.out.print(" "+arr[i]);
    }
  }
  public static int[] reverse(int[] arr, int i, int j) {
    while(i<=j){
      int temp=arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
      i++;
      j--;
    }
    return arr;
  }
}
