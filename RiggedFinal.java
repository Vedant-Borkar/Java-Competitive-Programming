import java.util.Scanner;
import java.util.Arrays;

public class RiggedFinal {
    public static int findMinBarbellWeight(int n, int[] strengths, int[] endurances) {
        int polycarpStrength = strengths[0];
        int polycarpEndurance = endurances[0];

        // Sort the athletes by strength in descending order
        int[] sortedStrengths = Arrays.copyOf(strengths, n);
        Arrays.sort(sortedStrengths);
        int secondHighestStrength = sortedStrengths[n - 2]; // Second highest strength

        int[] sortedEndur = Arrays.copyOf(endurances, n);
        Arrays.sort(sortedEndur);
        int maxendur = sortedEndur[n - 1];
        int secondHighestEndur = sortedEndur[n - 2];
        int minWeight = -1;  // Initialize with a value that indicates "impossible to win"

        // Case 1: Polycarp has the highest strength
        if (polycarpStrength == sortedStrengths[n - 1] && polycarpEndurance == sortedEndur[n - 1] && polycarpEndurance!= secondHighestEndur) {
            minWeight = polycarpStrength;
        }

        // Case 2: Polycarp doesn't have the highest strength
        else {
            for (int i = 1; i < n; i++) {
                if (endurances[i] > polycarpEndurance && strengths[i] > polycarpStrength)
                    break;
                else if (endurances[i] > polycarpEndurance && strengths[i] < polycarpStrength) {
                    if (minWeight == -1)
                        minWeight = strengths[i] + 1;
                    else
                        minWeight = Math.min(minWeight, strengths[i] + 1);
                }
            }
        }
        return minWeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  // Number of test cases

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();  // Number of athletes in this test case
            int[] strengths = new int[n];
            int[] endurances = new int[n];

            for (int i = 0; i < n; i++) {
                strengths[i] = scanner.nextInt();
                endurances[i] = scanner.nextInt();
            }

            int result = findMinBarbellWeight(n, strengths, endurances);
            System.out.println(result);
        }
    }
}

/*if (endurances[i] < polycarpEndurance) {
                    if (strengths[i] > polycarpEndurance) {
                        if (minWeight == -1) {
                            minWeight = strengths[i] + 1;
                        } else {
                            minWeight = Math.min(minWeight, strengths[i] + 1);
                        }
                    }
                } else if (endurances[i] >= polycarpEndurance) {
                    if (minWeight == -1) {
                        minWeight =Math.min(strengths[i]+1,polycarpStrength);
                    } else {
                        minWeight = Math.min(minWeight, polycarpStrength);
                    }
                    */