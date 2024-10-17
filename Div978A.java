import java.io.*;
import java.util.*;

public class Div978A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        int t = Integer.parseInt(br.readLine());

        // Process each test case
        for (int testCase = 0; testCase < t; testCase++) {
            // Read the first line and extract n and r
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[] a = new int[n];

            // Read the array of a[n]
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                if (st.hasMoreTokens()) {
                    a[i] = Integer.parseInt(st.nextToken());
                } else {
                    throw new IOException("Insufficient input for array a");
                }
            }

            int ans = 0;
            int peeps = 0;

            // Logic to calculate the answer
            for (int i = 0; i < n; i++) {
                int chance = a[i] / 2;
                a[i] = a[i] % 2;
                peeps += a[i];
                int rows = r;
                ans += Math.min(rows, chance) * 2;
                r -= Math.min(rows, chance);
            }

            while (true) {
                int rest = 2 * (r - 1);
                int left = peeps - 1;
                if (rest >= left && left >= 0) {
                    ans++;
                    r--;
                    peeps--;
                } else {
                    break;
                }
            }

            // Output the result for this test case
            System.out.println(ans);
        }
    }
}
