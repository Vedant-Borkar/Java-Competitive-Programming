/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2000/problem/B
 * Name:B. Seating in a Bus
 */
import java.util.*;
class SeatingBus{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0){
      int n=sc.nextInt();
      int arr[]=new int[n];boolean flag=true;
      for(int i=0;i<n;i++) arr[i]=sc.nextInt();
      int l=arr[0],r=arr[0];
      for(int i=1;i<n;i++){
          if(arr[i]==l-1)l--;
          else if(arr[i]==r+1)r++;
          else{
            flag=false; break;
          }
      }
      if(flag) System.out.println("YES");
      else System.out.println("NO");
    }
  }
}