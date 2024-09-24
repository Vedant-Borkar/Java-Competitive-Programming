import java.util.Scanner;

class GoodTriple {

    public static long countGoodTriples(int n) {
        long result = 1;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            int count = 0;
            for (int i = 0; i <= digit; ++i) {
                for (int j = 0; j <= digit - i; ++j) {
                    if (digit - i - j >= 0) {
                        count++;
                    }
                }
            }
            result *= count;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(countGoodTriples(n));
        }

        scanner.close();
    }
}
