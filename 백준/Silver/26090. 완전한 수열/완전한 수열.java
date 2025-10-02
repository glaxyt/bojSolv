import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] isPrimeCache;
    static final int MAX = 1000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        sieve();

        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int length = j - i;
                int sum = prefixSum[j] - prefixSum[i];

                if (isPrime(length) && isPrime(sum)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void sieve() {
        isPrimeCache = new boolean[MAX];
        Arrays.fill(isPrimeCache, true);
        isPrimeCache[0] = isPrimeCache[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            if (isPrimeCache[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrimeCache[j] = false;
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n < 0 || n >= MAX) return false;
        return isPrimeCache[n];
    }
}
