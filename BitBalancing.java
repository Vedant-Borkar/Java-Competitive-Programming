/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2020/problem/C
 * Name:CodeChef.S157.C. Bitwise Balancing
 */
import java.io.*;
import java.util.*;

public class BitBalancing {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            long a = 0;
            for (int bit = 62; bit >= 0; bit--) {
                if (isSet(d, bit)) {
                    if (!isSet(b, bit)) a += 1L << bit;
                } else {
                    if (isSet(c, bit)) a += 1L << bit;
                }
            }

            long res = (a | b) - (a & c);
            System.out.println(res == d ? a : -1);
        }
    }

    private static boolean isSet(long x, int bit) {
        return ((x >> bit) & 1L) == 1L;
    }
}
