import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CountParityPairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            solve(scanner);
        }

        scanner.close();
    }

    public static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        long countEven = 0, countOdd = 0;

        PriorityQueue<Long> oddNumbers = new PriorityQueue<>();
        HashMap<Long, Long> evenNumbers = new HashMap<>();

        for (int j = 0; j < n; j++) {
            long num = scanner.nextLong();

            if (num % 2 == 0) {
                countEven++;
                evenNumbers.put(num, evenNumbers.getOrDefault(num, 0L) + 1L);
            } else {
                countOdd++;
                oddNumbers.add(num);
            }
        }

        // Handle cases with only even or only odd numbers
        if (countEven == 0 || countOdd == 0) {
            System.out.println(0);
            return;
        }

        long answer = 0;
        while (!evenNumbers.isEmpty() && !oddNumbers.isEmpty()) {
            long smallestEven = evenNumbers.keySet().iterator().next();
            long largestOdd = oddNumbers.peek();

            if (largestOdd > smallestEven) {
                evenNumbers.put(smallestEven, evenNumbers.get(smallestEven) - 1L);
                if (evenNumbers.get(smallestEven) == 0L) {
                    evenNumbers.remove(smallestEven);
                }
                smallestEven += largestOdd;
                oddNumbers.add(smallestEven);
                answer++;
            } else {
                // Handle the case where smallestEven == largestOdd
                evenNumbers.put(smallestEven, evenNumbers.get(smallestEven) - 1L);
                if (evenNumbers.get(smallestEven) == 0L) {
                    evenNumbers.remove(smallestEven);
                }
                oddNumbers.poll();
                answer += 2;
            }
        }

        System.out.println(answer);
    }
}
