/**
 * Author: Vedant_Borkar
 * Problem: https://leetcode.com/problems/jump-game/
 * Name: 55 LC
 */
import java.util.*;
public class LCJumping {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int[n];
    for(int i=0;i<n;i++) arr[i]=sc.nextInt();

    int goal=n-1;
    //Instead of moving from 0th index to goal
    //since multiple different jumps are possible we instead bring goal to 0th position
    //iterating backwards with condition:
    // currentposition + maxjumpatthatposition >= goal

    for(int i=n-2;i>=0;i--){
      if(i+arr[i]>=goal) goal=i;
    }

    if(goal==0) System.out.println("yes");
    else System.out.println("No");
  }
  
}
