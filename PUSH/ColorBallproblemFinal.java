import java.util.*;
public class ColorBallproblemFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Cost(numbers, k);
    }
    public static void Cost(int[] numbers, int k) {
        //slide window
        for (int i = 0; i <= numbers.length - k; i++) {
            int left = i;
            int right = i + k - 1;
            int median = findMedian(numbers, left, right);

            // cost will be difference from median
            int cost = 0;
            for (int j = left; j <= right; j++) {
                cost += Math.abs(numbers[j] - median);//find cost and add
            }

            System.out.print(cost+ " ");
        }
    }
    public static int findMedian(int[] numbers, int left, int right) {
        int[] window = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            window[i - left] = numbers[i];
        }
        java.util.Arrays.sort(window);
        //for odd no. of window elements middle element is the median
        //for even it will round
        return window[window.length / 2];
    }
}
