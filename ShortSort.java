import java.util.Scanner;

public class ShortSort {
    // Function to check if it's possible to arrange the cards in 'abc' order
    static String canArrangeABC(String cards) {
        if (cards.equals("abc") || cards.equals("acb") || cards.equals("bac")
                 || cards.equals("cba")) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of test cases
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Process each test case
        for (int i = 0; i < t; i++) {
            String cards = scanner.nextLine();
            String result = canArrangeABC(cards);
            System.out.println(result);
        }

        scanner.close();
    }
}
