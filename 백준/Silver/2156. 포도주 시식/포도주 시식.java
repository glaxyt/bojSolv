import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 페이지 수 먼저 보여주고, 나서 역순으로 돌려야한다.
        // Why? 1번만 사용가능하고 DP로 가야하기 때문

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        List<Integer> drinks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int drink = Integer.parseInt(br.readLine());
            drinks.add(drink);
        }

        if (n == 1) {
            System.out.println(drinks.get(0));
        } else if (n == 2) {
            System.out.println(drinks.get(0) + drinks.get(1));
        } else {
            dp[0] = drinks.get(0);
            dp[1] = drinks.get(0) + drinks.get(1);
            dp[2] = Math.max(drinks.get(0) + drinks.get(2), Math.max(dp[1], drinks.get(1) + drinks.get(2)));
            int answer = Math.max(dp[1], dp[2]);

            for (int i=3; i<n; i++) {
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + drinks.get(i), drinks.get(i) + drinks.get(i-1) + dp[i-3]));
                answer = Math.max(answer, dp[i]);
            }

            System.out.println(answer);
        }
    }
}
