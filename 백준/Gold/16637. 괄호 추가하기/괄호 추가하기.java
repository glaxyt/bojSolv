import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String s;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        solve(1, Integer.parseInt(s.substring(0, 1)));
        System.out.println(answer);
    }

    public static void solve(int idx, int result) {
        if (idx >= n) {
            answer = Math.max(answer, result);
            return;
        }

        solve(idx + 2, calc(s.substring(idx, idx + 1), result, Integer.parseInt(s.substring(idx + 1, idx + 2))));

        if (idx + 3 < n) {
            int temp = calc(s.substring(idx + 2, idx + 3), Integer.parseInt(s.substring(idx + 1, idx + 2)), Integer.parseInt(s.substring(idx + 3, idx + 4)));
            solve(idx + 4, calc(s.substring(idx, idx + 1), result, temp));
        }

    }

    public static int calc(String ops, int a, int b) {
        if (ops.equals("+")) {
            return a + b;
        } else if (ops.equals("-")) {
            return a - b;
        } else {
            return a * b;
        }
    }
}
