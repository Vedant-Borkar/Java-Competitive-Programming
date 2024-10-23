package CodeChef.S157;

import java.io.*;
import java.util.*;

 class C {
    static class FReader {
        BufferedReader br;
        StringTokenizer st;

        public FReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nxt() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nxtInt() {
            return Integer.parseInt(nxt());
        }
    }

    static class FWriter {
        private final BufferedWriter bw;

        public FWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void prt(Object obj) throws IOException {
            bw.append(obj.toString());
        }

        public void prtln(Object obj) throws IOException {
            prt(obj);
            bw.append("\n");
        }

        public void cls() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) throws IOException {
        FReader in = new FReader();
        FWriter out = new FWriter();

        int t = in.nxtInt();
        while (t-- > 0) {
            int n = in.nxtInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                arr[i] = in.nxtInt();
            }
            long res = solve(n, arr);
            out.prtln(res);
        }
        out.cls();
    }

    private static long solve(int n, int[] arr) {
        int[] cur = arr.clone();
        boolean swp;

        do {
            swp = false;
            for (int i = 0; i < n; i++) {
                if (cur[i] <= 2 * cur[n] && cur[i] > cur[n]) {
                    int tmp = cur[i];
                    cur[i] = cur[n];
                    cur[n] = tmp;
                    swp = true;
                    break;
                }
            }
        } while (swp);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cur[i];
        }

        return sum;
    }
}
