/**
 * Author: Vedant_Borkar
 * Problem: https://leetcode.com/problems/jump-game-ii/
 * Name: 45 LC
 */
import java.util.*;
public class LCJumpGame2 {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int nums[]=new int[n];
    for(int i=0;i<n;i++) nums[i]=sc.nextInt();

    int near = 0, far = 0, jumps = 0;

    while (far < nums.length - 1) {
        int farthest = 0;
        for (int i = near; i <= far; i++) {
            farthest = Math.max(farthest, i + nums[i]);
        }
        near = far + 1;
        far = farthest;
        jumps++;
    }
    System.out.println(" Count = " + jumps);
  }
  
}
