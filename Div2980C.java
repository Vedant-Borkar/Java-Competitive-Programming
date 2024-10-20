/**
 * Author:Vedant_Borkar
 * Problem:https://codeforces.com/contest/2024/problem/C
 * Name:C. Concatenation of Arrays
 */
import java.util.*;
import java.io.*;

public class Div2980C {
    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[][] p = new long[n][2];
            long[] v = new long[2 * n];

            for (int i = 0; i < n; ++i) {
                String[] input = br.readLine().split(" ");
                p[i][0] = Long.parseLong(input[0]);
                p[i][1] = Long.parseLong(input[1]);
                v[2 * i] = p[i][0];
                v[2 * i + 1] = p[i][1];
            }

            Arrays.sort(v);
            Map<Long, Integer> m = new HashMap<>();
            long[][] c = new long[n][2];
            int idx = 1;
            for (int i = 0; i < 2 * n; i++) {
                if (!m.containsKey(v[i])) {
                    m.put(v[i], idx++);
                }
            }

            for (int i = 0; i < n; ++i) {
                c[i][0] = m.get(p[i][0]);
                c[i][1] = m.get(p[i][1]);
            }

            long[][] r = new long[n][3];
            for (int i = 0; i < n; ++i) {
                long s = c[i][0] + c[i][1];
                r[i][0] = s;
                r[i][1] = p[i][0];
                r[i][2] = p[i][1];
            }

            Arrays.sort(r, (a, b) -> Long.compare(a[0], b[0]));

            for (int i = 0; i < n; ++i) {
                out.print(r[i][1] + " " + r[i][2] + " ");
            }
            out.println();
        }

        out.flush();
        out.close();
    }
}
