import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class hackercup1 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("subsonic_subway_input.txt"));

            BufferedWriter bw = new BufferedWriter(new FileWriter("output1.txt"));
            List<String> results = new ArrayList<>();

            int t = Integer.parseInt(br.readLine().trim());

            for (int caseNum = 1; caseNum <= t; caseNum++) {
                int n = Integer.parseInt(br.readLine().trim());
                double low = 0.0;
                double upp = Double.POSITIVE_INFINITY;
                boolean valid = true;

                for (int i = 0; i < n; i++) {
                    String[] line = br.readLine().split(" ");
                    int a = Integer.parseInt(line[0]);
                    int b = Integer.parseInt(line[1]);
                    int dist = i + 1;

                    if (b == 0) {
                        valid = false;
                        break;
                    }

                    low = Math.max(low, dist / (double) b);
                    if (a > 0) {
                        upp = Math.min(upp, dist / (double) a);
                    }
                }

                if (valid && low <= upp) {
                    results.add(String.format("Case #%d: %.6f", caseNum, low));
                } else {
                    results.add(String.format("Case #%d: -1", caseNum));
                }
            }

            for (String result : results) {
                bw.write(result);
                bw.newLine();
            }

            br.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
