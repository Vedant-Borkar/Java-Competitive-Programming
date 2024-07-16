import java.util.Scanner;

public class WordoniaWizardGPT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //KILL ME AT THIS POINT
        //AS an SE i had to wtf is Dynamic Programming and then solve this problem
        //took me hours i wanna die
        String str1 = scanner.next();
        String str2 = scanner.next();

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);

    }
}
