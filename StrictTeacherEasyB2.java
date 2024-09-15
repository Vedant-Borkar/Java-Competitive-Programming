/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2005/problem/B2
 * Name:B2. Strict Teacher Easy
 */
import java.io.*;
import java.util.*;
public class StrictTeacherEasyB2 {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = sc.nextInt(); 

        while (t-- > 0) {
            int n = sc.nextInt();  
            int m = sc.nextInt();  
            int q = sc.nextInt();  

            int[] a = new int[m];
            for (int i = 0; i < m; i++) a[i] = sc.nextInt();
            Arrays.sort(a);

            for (int i = 0; i < q; i++) {
                int d = sc.nextInt();
                if (Arrays.binarySearch(a, d) >= 0) {
                    bw.write("0\n");
                    continue;
                }
                if (d < a[0]) {
                    bw.write((a[0] - 1) + "\n");
                    continue;
                }
                if (d > a[m - 1]) {
                    bw.write((n - a[m - 1]) + "\n");
                    continue;
                }
                int l = 0, r = m - 1;
                while (r - l > 1) {
                    int mid = (l + r) / 2;
                    if (a[mid] < d) l = mid;
                    else r = mid;
                }
                bw.write(((a[r] - a[l]) / 2) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

