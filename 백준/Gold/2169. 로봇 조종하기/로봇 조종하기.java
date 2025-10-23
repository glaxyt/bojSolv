import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] grid;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        grid = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for (int i=1; i<=n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=1; j<=m; j++) {
                grid[i][j] = line[j-1];
            }
        }

        // 첫행 초기화
        dp[1][1] = grid[1][1];
        for (int j=2; j<=m; j++) {
            dp[1][j] = dp[1][j - 1] + grid[1][j];
        }

        for(int i=2; i<=n; i++){
            int[] left = new int[m+1];
            int[] right = new int[m+1];

            // 오른쪽 이동.
            left[1] = dp[i-1][1] + grid[i][1];

            for(int j=2; j<=m; j++){
                left[j] = Math.max(left[j-1], dp[i-1][j]) + grid[i][j];
            }

            // 왼쪽으로 이동
            right[m] = dp[i-1][m] + grid[i][m];

            for(int j=m-1; j>=1; j--){
                right[j] = Math.max(right[j+1], dp[i-1][j]) + grid[i][j];
            }

            for(int j=1; j<=m; j++){
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[n][m]);

    }
}
