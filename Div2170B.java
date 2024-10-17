import java.io.*;
import java.util.*;

public class  Div2170B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st2.nextToken());

            long ans;
            if (n == k || k == 0) {
                ans = 0;
            } else {
                ans = binpow(2, k);
            }

            out.println(ans % 1000000007);
        }

        out.flush();
        out.close();
        br.close();
    }

    static long binpow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % 1000000007;
            }
            base = (base * base) % 1000000007;
            exp >>= 1;
        }
        return result;
    }
}