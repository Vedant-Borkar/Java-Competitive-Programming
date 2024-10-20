/**
 * Author:Vedant_Borkar
 * Problem:https://codeforces.com/gym/105435/problem/F2
 * Name:F2. Dhrumil and Abhishek Game 2
 */
import java.io.*;
import java.util.*;

public class mashF2 {
    static class SegmentTree {
        long[] sum;
        long[] weightedSum;
        int n;

        SegmentTree(int size) {
            n = size;
            sum = new long[4 * n];
            weightedSum = new long[4 * n];
        }

        void build(long[] arr, int node, int start, int end) {
            if (start == end) {
                sum[node] = arr[start];
                weightedSum[node] = arr[start] * start;
            } else {
                int mid = (start + end) / 2;
                build(arr, 2 * node, start, mid);
                build(arr, 2 * node + 1, mid + 1, end);
                sum[node] = sum[2 * node] + sum[2 * node + 1];
                weightedSum[node] = weightedSum[2 * node] + weightedSum[2 * node + 1];
            }
        }

        void update(int node, int start, int end, int idx, long val) {
            if (start == end) {
                sum[node] = val;
                weightedSum[node] = val * start;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            sum[node] = sum[2 * node] + sum[2 * node + 1];
            weightedSum[node] = weightedSum[2 * node] + weightedSum[2 * node + 1];
        }

        long querySum(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return sum[node];
            int mid = (start + end) / 2;
            return querySum(2 * node, start, mid, l, r) + querySum(2 * node + 1, mid + 1, end, l, r);
        }

        long queryWeightedSum(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return weightedSum[node];
            int mid = (start + end) / 2;
            return queryWeightedSum(2 * node, start, mid, l, r) + queryWeightedSum(2 * node + 1, mid + 1, end, l, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            long[] arr = new long[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            SegmentTree segTree = new SegmentTree(n);
            segTree.build(arr, 1, 1, n);

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int queryType = Integer.parseInt(st.nextToken());
                if (queryType == 1) {
                    int index = Integer.parseInt(st.nextToken());
                    long value = Long.parseLong(st.nextToken());
                    segTree.update(1, 1, n, index, value);
                } else {
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    long weightedSum = segTree.queryWeightedSum(1, 1, n, l, r);
                    long sum = segTree.querySum(1, 1, n, l, r);
                    long result = weightedSum - (l - 1) * sum;
                    out.println(result);
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
}