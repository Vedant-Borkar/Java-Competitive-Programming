
import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println(1);
            } else if (n == 2) {
                System.out.println(-1);
            } else {
                for (int i = 1; i <= n; i += 2) {
                    System.out.print(i + " ");
                }
                for (int i = 2; i <= n; i += 2) {
                    System.out.print(i + (i + 2 > n ? "\n" : " "));
                }
            }
        }
        sc.close();
    }
}
