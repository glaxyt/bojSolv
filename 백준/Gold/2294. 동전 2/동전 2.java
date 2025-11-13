import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        List<Integer> coins = new ArrayList<>();
        int[] dp = new int[m+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin > m) continue;
            coins.add(coin);
            dp[coin] = 1;
        }

        dp[0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int coinIdx = 0; coinIdx < coins.size(); coinIdx++) {
                int pCoin = i - coins.get(coinIdx);

                if (0 <= pCoin && pCoin < m && dp[pCoin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[pCoin] + 1);
                }
            }
        }

        System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
    }
}


