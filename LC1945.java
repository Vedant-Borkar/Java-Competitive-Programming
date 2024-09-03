/**
 * Author: Vedant_Borkar
 * Problem: https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/
 * Name: 1945 LC
 */
import java.util.*;
public class LC1945 {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
      String s=sc.next();
      int k=sc.nextInt();
      System.out.println(getLucky(s,k));
  }
  public static int getLucky(String s, int k) {
    ArrayList<Integer> list=new ArrayList<Integer>();
    for(int i=0;i<s.length();i++){
      list.add(s.charAt(i)-'a'+1);
    }
    String str="";
    for(int i=0;i<list.size();i++){
      str+=list.get(i);
    }
    int num=0;
    if(k==0){
      return Integer.parseInt(str);
    }else{
      while(k!=0){
        int sum1=0;
        for(int i=0;i<str.length();i++){
          sum1+=str.charAt(i)-'0';
        }
        num=sum1;
        str=Integer.toString(sum1);
        k--;
      }
      return num;
    }
  }
}
