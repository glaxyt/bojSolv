import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] isPrime;
    static final int MAX = 118;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= MAX; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        while (n-- > 0) {
            int a = Integer.parseInt(br.readLine());
            boolean flag = false;

            for (int i = 2; i < a; i++) {
                if (isPrime[i] && isPrime[a-i]) {
                    flag = true;
                    break;
                }
            }

            if (flag) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
