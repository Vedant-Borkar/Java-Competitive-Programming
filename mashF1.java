/**
 * Author:Vedant_Borkar
 * Problem:https://codeforces.com/gym/105435/problem/F1
 * Name:F1. Dhrumil and Abhishek Game 1
 */
import java.util.Scanner;

public class mashF1 {
    static class SegmentTree {
        long[] tree;
        long[] lazy;
        int n;

        SegmentTree(int size) {
            n = size;
            tree = new long[4 * n];
            lazy = new long[4 * n];
        }

        void build(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start] * start;
            } else {
                int mid = (start + end) / 2;
                build(arr, 2 * node, start, mid);
                build(arr, 2 * node + 1, mid + 1, end);
                tree[node] = tree[2 * node] + tree[2 * node + 1];
            }
        }

        void update(int node, int start, int end, int idx, long val) {
            if (start == end) {
                tree[node] = val * start;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        long query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return 0;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            long left = query(2 * node, start, mid, l, r);
            long right = query(2 * node + 1, mid + 1, end, l, r);
            return left + right;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();

            long[] arr = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = scanner.nextLong();
            }

            SegmentTree st = new SegmentTree(n);
            st.build(arr, 1, 1, n);

            for (int i = 0; i < q; i++) {
                int queryType = scanner.nextInt();
                if (queryType == 1) {
                    int index = scanner.nextInt();
                    long value = scanner.nextLong();
                    st.update(1, 1, n, index, value);
                } else {
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    long weightedSum = st.query(1, 1, n, l, r);
                    long totalSum = (r - l + 1) * (l - 1);
                    System.out.println(weightedSum - totalSum);
                }
            }
        }
        scanner.close();
    }
}