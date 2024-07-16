import java.util.Scanner;

public class Papergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[][] dp = new int[w + 1][h + 1];

        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= h; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i - k][j] + 1);
                    }
                    for (int k = 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[i][j - k] + 1);
                    }
                }
            }
        }

        System.out.println(dp[w][h]);
    }
}
