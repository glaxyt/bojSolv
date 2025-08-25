import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line[j];
            }
        }

        dp = new long[n][n];
        for (long[] row : dp) Arrays.fill(row, -1);

        System.out.println(dfs(0, 0, n));
    }

    static long dfs(int x, int y, int n) {
        if (x == n - 1 && y == n - 1) return 1L;

        if (grid[x][y] == 0) return 0L;

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0L;
        int jump = grid[x][y];

        if (canMove(n, x + jump, y)) dp[x][y] += dfs(x + jump, y, n);
        if (canMove(n, x, y + jump)) dp[x][y] += dfs(x, y + jump, n);

        return dp[x][y];
    }

    private static boolean canMove(int n, int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
