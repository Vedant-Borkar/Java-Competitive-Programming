/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2000/problem/A
 * Name:A. Primary Task
 */
import java.util.Scanner;

public class PrimaryTask{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String num = sc.next();
            
            if (num.length() >= 2 && num.substring(0, 2).equals("10")) {
                if (num.length() == 3 && num.charAt(2) == '1') {
                    System.out.println("NO");
                } else if (num.length() >=3 && num.charAt(2) != '0'){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}