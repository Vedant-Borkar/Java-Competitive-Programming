import java.util.*;

public class yes1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            int r = scanner.nextInt();
            Integer[] families = new Integer[n];

            for (int i = 0; i < n; i++) {
                families[i] = scanner.nextInt();
            }

            System.out.println(maximizeHappyPeople(families, r));
        }

        scanner.close();
    }

    private static int maximizeHappyPeople(Integer[] families, int rows) {
        Arrays.sort(families, Collections.reverseOrder());

        int maxHappy = 0;
        int remainingSeats = rows * 2;

        // Handle pairs
        for (int i = 0; i < families.length; i++) {
            if (families[i] >= 2 && remainingSeats >= 2) {
                int pairs = families[i] / 2;
                maxHappy += pairs * 2;
                remainingSeats -= pairs * 2;
                families[i] %= 2;
            }
        }

        // Handle singles
        for (int i = 0; i < families.length; i++) {
            if (families[i] == 1 && remainingSeats > 0) {
                maxHappy++;
                remainingSeats--;
            }
        }

        return maxHappy;
    }
}