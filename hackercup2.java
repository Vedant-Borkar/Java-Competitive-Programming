import java.io.*;
import java.util.*;

public class hackercup2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prime_subtractorization_validation_input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output2a.txt"));
            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                int N = Integer.parseInt(br.readLine());
                bw.write("Case #" + t + ": " + solve(N) + "\n");
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        Set<Integer> subtractions = new HashSet<>();
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        for (int i = 0; i < primes.size(); i++) {
            int p = primes.get(i);
            for (int j = i + 1; j < primes.size(); j++) {
                int q = primes.get(j);
                int diff = q - p;
                if (diff > N) break;
                if (isPrime[diff]) {
                    subtractions.add(diff);
                }
            }
        }

        return subtractions.size();
    }
}