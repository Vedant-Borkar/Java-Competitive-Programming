/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/gym/105380/problem/E
 * Name:E. String Palindrome Game
 */
import java.io.*;

public class StringPalindromeGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] nq = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nq[0]);
            int q = Integer.parseInt(nq[1]);

            String s = br.readLine().trim();

            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            for (int len = 2; len <= n; len++) {
                for (int i = 0; i < n - len + 1; i++) {
                    int j = i + len - 1;
                    if (s.charAt(i) == s.charAt(j) && len == 2) {
                        dp[i][j] = 2;
                    } else if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }

            for (int i = 0; i < q; i++) {
                String[] lr = br.readLine().trim().split(" ");
                int l = Integer.parseInt(lr[0]) - 1;
                int r = Integer.parseInt(lr[1]) - 1;
                System.out.println(dp[l][r]);
            }
        }
    }
}