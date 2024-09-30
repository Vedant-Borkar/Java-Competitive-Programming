import java.io.*;

public class BrightnessBegins {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            long k = Long.parseLong(br.readLine());
            System.out.println(findSmallestN(k));
        }
    }

    public static long findSmallestN(long k) {
        long low = k, high = 2 * k, res = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long activeBits = mid - (long) Math.sqrt(mid);

            if (activeBits == k) {
                res = mid;
                high = mid - 1;
            } else if (activeBits < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}
