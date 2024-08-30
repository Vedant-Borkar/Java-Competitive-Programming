/**
 * Author: Vedant_Borkar
 * Problem: https://codeforces.com/contest/2002/problem/B
 * Name: B. Removals Game
 */
import java.util.*;

public class RemovalsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            List<Integer> a = new ArrayList<>(), b = new ArrayList<>();
            for (int i = 1; i <= n; i++) a.add(sc.nextInt());
            for (int i = 1; i <= n; i++) b.add(sc.nextInt());

            if (a.equals(b)) {
                System.out.println("Bob");
                continue;
            }

            Collections.reverse(a);

            if (a.equals(b)) {
                System.out.println("Bob");
                continue;
            }

            System.out.println("Alice");
        }
    }
}
