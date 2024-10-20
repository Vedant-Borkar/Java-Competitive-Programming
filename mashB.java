/**
 * Author:Vedant_Borkar
 * Problem:
 * Name:
 */

import java.io.*;
import java.util.*;

public class mashB{
    private static final int MX = 1000000;
    private static int[] psq = new int[MX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        pre();

        int q = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (t == 1) {
                out.println(countOdd(l, r));
            } else {
                out.println(r - l + 1 - countOdd(l, r));
            }
        }

        out.flush();
        out.close();
        br.close();
    }

    private static void pre() {
        for (int i = 1; i * i <= MX; i++) {
            psq[i * i]++;
        }
        for (int i = 1; i <= MX; i++) {
            psq[i] += psq[i - 1];
        }
    }

    private static int countOdd(int l, int r) {
        return countPsq(r) - countPsq(l - 1);
    }

    private static int countPsq(int n) {
        if (n <= MX) {
            return psq[n];
        }
        return (int) Math.sqrt(n);
    }
}
