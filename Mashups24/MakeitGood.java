/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/gym/105380/problem/D
 * Name:D. Make It Good
 */
import java.util.*;
import java.io.*;

public class MakeitGood {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] input = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            int lgp = 1;

            for (int pl = 2; pl <= n; pl++) {
                int[] pre = Arrays.copyOfRange(arr, 0, pl);
                int[] sortedPre = Arrays.copyOf(pre, pre.length);
                Arrays.sort(sortedPre);

                if (canForm(pre, sortedPre)) {
                    lgp = pl;
                } else {
                    break;
                }
            }

            System.out.println(lgp);
        }
    }

    private static boolean canForm(int[] orig, int[] sorted) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int num : orig) {
            dq.add(num);
        }

        for (int i = 0; i < sorted.length; i++) {
            if (dq.getFirst() == sorted[i]) {
                dq.removeFirst();
            } else if (dq.getLast() == sorted[i]) {
                dq.removeLast();
            } else {
                return false;
            }
        }
        return true;
    }
}
