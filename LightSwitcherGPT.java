import java.io.*;
import java.util.*;

public class LightSwitcherGPT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            bw.write(solve(n, k, a) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int solve(int n, int k, int[] a) {
        Set<Integer> criticalTimes = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                criticalTimes.add(a[i] + j * k);
            }
        }

        boolean[] isOn = new boolean[n];
        int onCount = 0;

        for (int time : criticalTimes) {
            for (int i = 0; i < n; i++) {
                if (time >= a[i]) {
                    int sinceinstall = time - a[i];
                    boolean shldbeon = (sinceinstall / k) % 2 == 0;

                    if (shldbeon != isOn[i]) {
                        isOn[i] = shldbeon;
                        onCount += shldbeon ? 1 : -1;
                    }
                }
            }

            if (onCount == n) {
                return time;
            }
        }

        return -1;
    }
}
