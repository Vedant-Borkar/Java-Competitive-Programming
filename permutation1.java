import java.util.Scanner;

public class permutation1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            if (n % 2 == 0) {
                System.out.println("-1");
            } else {
                for (int j = 1; j <= n / 2; j++) {
                    System.out.print(j + " ");
                }
                System.out.print(n + " ");
                for (int j = n - 1; j > n / 2; j--) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
