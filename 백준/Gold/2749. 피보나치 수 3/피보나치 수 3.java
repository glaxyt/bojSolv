import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        int period = 1500000;
        n = n % period;

        System.out.println(fibo(n));
    }

    private static long fibo(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0;
        long b = 1;

        for (long i = 2; i <= n; i++) {
            long temp = (a + b) % 1000000;
            a = b;
            b = temp;
        }

        return b;
    }
}