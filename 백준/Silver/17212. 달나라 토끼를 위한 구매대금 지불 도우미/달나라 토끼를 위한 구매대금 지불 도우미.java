import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> coins = new ArrayList<>(List.of(1, 2, 5, 7));
        int[] dp = new int[100_001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int coin : coins) {
            dp[coin] = 1;
        }

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }

}