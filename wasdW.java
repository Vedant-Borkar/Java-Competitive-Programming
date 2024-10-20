import java.util.Scanner;

public class wasdW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            long a = sc.nextLong(); // time when Sagar first gets busy
            long b = sc.nextLong(); // interval between busy periods
            long c = sc.nextLong(); // time when Jagjeet wants to play

            if (isSagarBusy(a, b, c)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        sc.close();
    }

    private static boolean isSagarBusy(long a, long b, long c) {
        if (c < a) return false;

        long timeSinceFirstBusy = c - a;
        long fullCycles = timeSinceFirstBusy / b;
        long remainder = timeSinceFirstBusy % b;

        return remainder == 0 || remainder == 1;
    }
}