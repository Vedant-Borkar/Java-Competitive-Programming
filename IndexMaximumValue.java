import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class IndexMaximumValue {
    static class SegmentTree {
        int n;
        long[] tree, lazy;

        SegmentTree(int size) {
            n = size;
            tree = new long[4 * n];
            lazy = new long[4 * n];
        }

        void propagate(int node, int start, int end) {
            if (lazy[node] != 0) {
                tree[node] += lazy[node];
                if (start != end) {
                    lazy[2 * node] += lazy[node];
                    lazy[2 * node + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }

        void update(int node, int start, int end, int l, int r, int val) {
            propagate(node, start, end);
            if (start > r || end < l) return;

            if (l <= start && end <= r) {
                tree[node] += val;
                if (start != end) {
                    lazy[2 * node] += val;
                    lazy[2 * node + 1] += val;
                }
                return;
            }

            int mid = (start + end) / 2;
            update(2 * node, start, mid, l, r, val);
            update(2 * node + 1, mid + 1, end, l, r, val);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        long query(int node, int start, int end, int l, int r) {
            propagate(node, start, end);
            if (start > r || end < l) return Long.MIN_VALUE;

            if (l <= start && end <= r) return tree[node];

            int mid = (start + end) / 2;
            return Math.max(query(2 * node, start, mid, l, r),
                            query(2 * node + 1, mid + 1, end, l, r));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            SegmentTree seg = new SegmentTree(n);
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(st.nextToken());
                seg.update(1, 0, n - 1, i, i, val);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken()) - 1;
                int val = op == '+' ? 1 : -1;

                seg.update(1, 0, n - 1, l, r, val);
                sb.append(seg.query(1, 0, n - 1, 0, n - 1)).append(" ");
            }

            bw.write(sb.toString().trim() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}