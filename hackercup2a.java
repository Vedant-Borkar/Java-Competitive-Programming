import java.io.*;
import java.util.*;

public class hackercup2a {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("prime_subtractorization_validation_input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output2.txt"));
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
        List<Integer> primes = genPrimes(N);
        Set<Integer> subtractions = new HashSet<>();

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size() && primes.get(j) <= N * N; j++) {
                int diff = primes.get(j) - primes.get(i);
                if (diff > 0 && diff <= N && primes.contains(diff)) {
                    subtractions.add(diff);
                }
            }
        }

        return subtractions.size();
    }

    private static List<Integer> genPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
