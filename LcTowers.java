import java.util.Arrays;
import java.util.HashSet;
import java.util.*;
class LcTowers {
    public static long maximumTotalSum(int[] hMax) {
        int n = hMax.length;
        Arrays.sort(hMax);

        // Use a TreeSet instead of PriorityQueue for faster operations
        TreeSet<Integer> availableHeights = new TreeSet<>();

        long sum = 0;
        int maxHeight = hMax[n - 1];

        for (int i = n - 1; i >= 0; i--) {
            // Add heights only up to the current maximum
            while (availableHeights.size() < maxHeight - hMax[i]) {
                availableHeights.add(maxHeight);
                maxHeight--;
            }

            // Find the largest height not exceeding hMax[i]
            Integer height = availableHeights.floor(hMax[i]);

            if (height == null) {
                return -1;
            }

            sum += height;
            availableHeights.remove(height);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) arr[i]= sc.nextInt();
        System.out.println(maximumTotalSum(arr));
    }
}
