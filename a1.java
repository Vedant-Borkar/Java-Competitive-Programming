import java.util.*;
import java.io.*;

public class a1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            out.println(maxSequence(n, k, a));
        }
        out.flush();
    }

    private static int maxSequence(int n, int k, int[] a) {
        int[] freq = new int[200001];
        boolean[] present = new boolean[200001];
        int maxVal = 0;

        for (int val : a) {
            freq[val]++;
            present[val] = true;
            maxVal = Math.max(maxVal, val);
        }

        int maxSeq = 0;

        for (int start = 1; start <= maxVal; start++) {
            if (!present[start]) continue;

            int count = 0;
            int total = 0;
            int curr = start;

            while (curr <= maxVal && count < k) {
                if (present[curr]) {
                    total += freq[curr];
                    count++;
                    curr++;
                } else {
                    break;
                }
            }

            maxSeq = Math.max(maxSeq, total);
        }

        return maxSeq;
    }
}
