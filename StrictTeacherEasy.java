/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2005/problem/B1
 * Name:B. Strict Teacher Easy
 */
import java.io.*;
import java.util.*;

public class StrictTeacherEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        while (t-- > 0) {
            int n = sc.nextInt(); 
            int m = sc.nextInt(); 
            int q = sc.nextInt(); 

            int[] te = new int[m];
            for (int i = 0; i < m; i++) {
                te[i] = sc.nextInt();
            }

            int dPos = sc.nextInt();
            int res = 0; 

            if (te[0] > te[1]) {
                int tmp = te[0];
                te[0] = te[1];
                te[1] = tmp;
            }
    
            if (dPos == te[0] + 1 || dPos == te[1] - 1) {
                res = 1;
            } else if (dPos > te[0] && dPos < te[1]) {
                res = Math.min(dPos - te[0], te[1] - dPos);
            } else if (dPos < te[0]) {
                res = te[0] - dPos;
            } else {
                res = dPos - te[1];
            }
            
            System.out.println(res);
        }
        sc.close();
    }
}
