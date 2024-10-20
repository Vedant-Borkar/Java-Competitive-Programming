import java.util.*;
import java.io.*;

public class wasd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            long k = Long.parseLong(nk[1]);

            ArrayList<Long> v = new ArrayList<>();
            v.add(0L);  // Adding 0 at index 0 to match 1-based indexing
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                v.add(Long.parseLong(inputs[i]));
            }

            Collections.sort(v);

            long c = 0, p = 0;
            for (int i = 1; i <= n; i++) {
                if (c + (n - i + 1) * (v.get(i) - v.get(i - 1)) >= k) {
                    p += (k - c);
                    break;
                }
                p += (n - i + 1) * (v.get(i) - v.get(i - 1)) + 1;
                c += (n - i + 1) * (v.get(i) - v.get(i - 1));
            }

            out.println(p);
        }

        out.flush();
        out.close();
    }
}