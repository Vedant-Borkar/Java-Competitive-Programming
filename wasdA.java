import java.util.*;

public class wasdA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            String s = scanner.next();

            int result = findShortestSubstring(s);
            System.out.println(result);
        }

        scanner.close();
    }

    private static int findShortestSubstring(String s) {
        int[] count = new int[26];
        int[] required = new int[26];
        String target = "hardwork";
        int uniqueChars = 0;

        // Initialize required characters
        for (char c : target.toCharArray()) {
            if (++required[c - 'a'] == 1) {
                uniqueChars++;
            }
        }

        int left = 0, minLength = Integer.MAX_VALUE;
        int matchedChars = 0;

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'a';
            if (++count[index] == required[index]) {
                matchedChars++;
            }

            while (matchedChars == uniqueChars) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                }

                index = s.charAt(left) - 'a';
                if (count[index]-- == required[index]) {
                    matchedChars--;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}