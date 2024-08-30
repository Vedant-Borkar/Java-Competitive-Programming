/**
 * Author: Vedant_Borkar
 * Problem: https://codeforces.com/contest/514/problem/A
 * Name: A. Chewbaсca and Number
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoprimeOperationsSolver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] lr = br.readLine().trim().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);

            System.out.println(maxOperations(l, r));
        }
    }

    public static int maxOperations(int l, int r) {
        if (r - l + 1 < 3) {
            return 0;
        }

        int count = 0;

        for (int i = l; i <= r - 2; i++) {
            for (int j = i + 1; j <= r - 1; j++) {
                for (int k = j + 1; k <= r; k++) {
                    if (gcd(i, j) == 1 && gcd(j, k) == 1 && gcd(i, k) == 1) {
                        count++;
                        i = k; // Jump to the next index after finding a valid triplet
                        break;
                    }
                }
            }
        }

        return count;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
