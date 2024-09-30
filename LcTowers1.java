import java.util.*;

class LcTowers1 {
    public static int[] validSequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        int lastIndex = -1;
        int changedIndex = -1;

        for (int i = 0; i < n; i++) {
            char c = word2.charAt(i);
            int index = word1.indexOf(c, lastIndex + 1);

            if (index == -1) {
                // Character not found after lastIndex, try from the beginning
                index = word1.indexOf(c);
                if (index == -1 || index > lastIndex) {
                    // Character not found at all or only found after lastIndex
                    if (changedIndex != -1) {
                        // We've already changed one character, so no valid sequence
                        return new int[0];
                    }
                    changedIndex = i;
                    continue;
                }
                // We found the character, but need to change the order
                if (changedIndex != -1) {
                    // We've already changed one character, so no valid sequence
                    return new int[0];
                }
                changedIndex = i;
            }

            result[i] = index;
            lastIndex = index;
        }

        if (changedIndex != -1) {
            // Find the correct position for the changed character
            char c = word2.charAt(changedIndex);
            for (int i = 0; i < m; i++) {
                if (word1.charAt(i) == c && (changedIndex == 0 || i > result[changedIndex - 1])) {
                    result[changedIndex] = i;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        int[] arr = validSequence(word1, word2);
        if (arr.length == 0) {
            System.out.println();  // Print empty line for no valid sequence
        } else {
            for (int i : arr) {
                System.out.println(i);
            }
            System.out.println();  // Print newline after the sequence
        }
        sc.close();
    }
}