import java.util.*;
import java.io.*;

public class a2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] records = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            records[i] = Integer.parseInt(st.nextToken());
        }

        out.println(solve(n, m, records));
        out.close();
    }

    private static int solve(int n, int m, int[] records) {
        int strength = 0;
        int intelligence = 0;
        int availablePoints = 0;
        int passedChecks = 0;

        for (int record : records) {
            if (record == 0) {
                availablePoints++;
            } else if (record > 0) {  // Intelligence check
                if (intelligence >= record) {
                    passedChecks++;
                } else if (availablePoints > 0) {
                    int neededPoints = record - intelligence;
                    if (neededPoints <= availablePoints) {
                        intelligence = record;
                        availablePoints -= neededPoints;
                        passedChecks++;
                    }
                }
            } else {  // Strength check
                int absRecord = Math.abs(record);
                if (strength >= absRecord) {
                    passedChecks++;
                } else if (availablePoints > 0) {
                    int neededPoints = absRecord - strength;
                    if (neededPoints <= availablePoints) {
                        strength = absRecord;
                        availablePoints -= neededPoints;
                        passedChecks++;
                    }
                }
            }
        }

        return passedChecks;
    }
}