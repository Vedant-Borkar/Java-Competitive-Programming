import java.util.*;
import java.io.*;

public class wasd1 {
    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.second != other.second) {
                return Integer.compare(this.second, other.second);  // Sort by second element
            }
            return Integer.compare(this.first, other.first);  // Tiebreaker: sort by first
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());  // Number of test cases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());  // Number of pairs
            List<Pair> pairs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().trim().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                pairs.add(new Pair(a, b));
            }

            // Sort the pairs by second element (and by first element in case of tie)
            Collections.sort(pairs);

            int last = -1;  // To track the last appended element
            for (Pair p : pairs) {
                // To minimize inversions, choose the correct order of the pair
                if (last == -1 || last <= p.first) {
                    res.append(p.first).append(" ").append(p.second).append(" ");
                    last = p.second;
                } else {
                    res.append(p.second).append(" ").append(p.first).append(" ");
                    last = p.first;
                }
            }
            res.append("\n");
        }

        System.out.print(res);
    }
}
