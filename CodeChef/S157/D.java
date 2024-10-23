package CodeChef.S157;

import java.io.*;
import java.util.*;

class D {
    static class FR {
        BufferedReader br;
        StringTokenizer st;

        public FR() {
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

        String nxtLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        FR fr = new FR();
        int t = fr.nxtInt();

        while (t-- > 0) {
            int n = Integer.parseInt(fr.nxtLine().trim());
            char[] s = fr.nxtLine().trim().toCharArray();
            System.out.println(findMin(s));
        }
    }

    private static int findMin(char[] s) {
        int n = s.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int totalOnes = 0;
        for (char c : s) {
            if (c == '1') totalOnes++;
        }

        if (totalOnes == 0) return n;
        if (totalOnes % 2 == 0) return 0;

        return 1;
    }
}