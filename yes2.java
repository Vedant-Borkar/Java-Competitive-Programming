import java.io.*;
import java.util.*;

public class yes2 {
    static int n;
    static String s1, s2;
    static Map<Pair<Integer, Integer>, Integer> mp;

    static class Pair<K, V> {
        K first;
        V second;

        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    static int solve(int i, int j) {
        if (i >= n || j >= n) return 0;
        Pair<Integer, Integer> key = new Pair<>(i, j);
        if (mp.containsKey(key)) return mp.get(key);
        int ans = 0;
        int cnt = 0;
        if (i == j) {
            cnt = 0;
            if (i + 1 < n) {
                if (s1.charAt(i) == 'A') cnt++;
                if (s1.charAt(i + 1) == 'A') cnt++;
                if (s2.charAt(j) == 'A') cnt++;
                if (cnt >= 2) ans = Math.max(ans, 1 + solve(i + 2, j + 1));
                else ans = Math.max(ans, solve(i + 2, j + 1));
            }
            cnt = 0;
            if (j + 1 < n) {
                if (s1.charAt(i) == 'A') cnt++;
                if (s2.charAt(j) == 'A') cnt++;
                if (s2.charAt(j + 1) == 'A') cnt++;
                if (cnt >= 2) ans = Math.max(ans, 1 + solve(i + 1, j + 2));
                else ans = Math.max(ans, solve(i + 1, j + 2));
            }
        }
        if (i == j + 1 && j + 1 < n) {
            cnt = 0;
            if (s1.charAt(i) == 'A') cnt++;
            if (s2.charAt(j) == 'A') cnt++;
            if (s2.charAt(j + 1) == 'A') cnt++;
            if (cnt >= 2) ans = Math.max(ans, 1 + solve(i + 1, j + 2));
            else ans = Math.max(ans, solve(i + 1, j + 2));
        }
        if (i == j - 1 && i + 1 < n) {
            cnt = 0;
            if (s1.charAt(i) == 'A') cnt++;
            if (s1.charAt(i + 1) == 'A') cnt++;
            if (s2.charAt(j) == 'A') cnt++;
            if (cnt >= 2) ans = Math.max(ans, 1 + solve(i + 2, j + 1));
            else ans = Math.max(ans, solve(i + 2, j + 1));
        }
        int p1 = 0, p2 = 0;
        cnt = 0;
        if (i + 2 < n) {
            cnt = 0;
            if (s1.charAt(i) == 'A') cnt++;
            if (s1.charAt(i + 1) == 'A') cnt++;
            if (s1.charAt(i + 2) == 'A') cnt++;
            if (cnt >= 2) p1 = 1;
        }
        if (j + 2 < n) {
            cnt = 0;
            if (s2.charAt(j) == 'A') cnt++;
            if (s2.charAt(j + 1) == 'A') cnt++;
            if (s2.charAt(j + 2) == 'A') cnt++;
            if (cnt >= 2) p2 = 1;
        }
        ans = Math.max(ans, p1 + p2 + solve(i + 3, j + 3));
        mp.put(key, ans);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            mp = new HashMap<>();
            n = Integer.parseInt(br.readLine());
            s1 = br.readLine();
            s2 = br.readLine();
            System.out.println(solve(0, 0));
        }
    }
}