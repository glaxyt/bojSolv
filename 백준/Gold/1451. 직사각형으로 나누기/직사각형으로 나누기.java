import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 직사각형의 곱의 최대 합.
        // 백트래킹처럼 3번 나누는건 안해봄.. 그리고 초과날 50^50 * 3 까지 가능하기때문.
        // 무조건적으로 모든 직사각형은 사이좋게 나머지공간이 없게 먹어야한다.

        // 생소하네..
        // 모든 직사각형의 합을 구한다. 왼쪽 위 꼭지점은 (0, 0) 고정,
        // 오른쪽 아래 꼭지점을 선택해서 계산해준다. 사실 이때 모든 직사각형의 위치는 모두 고정된다. 2가지 경우만 존재함.
        //
        // 이전에 선택한 아래 꼭지점의 열 혹은 행이 같은 꼭지점을 다음 직사각형의 왼쪽 꼭지점으로 잡아야 직사각형 탄생 가능.
        // 마지막은 무조건 전체 직사각형의 아래 오른쪽 꼭지점.
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] nums = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                grid[i][j] = nums[j] - '0';
            }
        }

        long[][] dp = new long[n][m];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + grid[i][j];
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        long answer = Long.MIN_VALUE;

        // 유동적인 직사각형 + 직선적인 직사각형
        for (int x1 = 0; x1 < n; x1++) {
            for (int x2 = x1+1; x2 < n-1; x2++) {
                answer = Math.max(dp[x1][m-1] * (dp[x2][m-1] - dp[x1][m-1]) * (dp[n-1][m-1] - dp[x2][m-1]), answer);
            }
            for (int y1 = 0; y1 < m; y1++) {
                answer = Math.max(dp[x1][m-1] * (dp[n-1][y1] - dp[x1][y1]) * (dp[n-1][m-1] - dp[n-1][y1] - dp[x1][m-1] + dp[x1][y1]), answer);
            }
        }

        for (int y1 = 0; y1 < m; y1++) {
            for (int y2 = y1+1; y2 < m-1; y2++) {
                answer = Math.max(dp[n-1][y1] * (dp[n-1][y2] - dp[n-1][y1]) * (dp[n-1][m-1] - dp[n-1][y2]), answer);
            }
            for (int x1 = 0; x1 < n; x1++) {
                answer = Math.max(dp[n-1][y1] * (dp[x1][m-1] - dp[x1][y1]) * (dp[n-1][m-1] - dp[n-1][y1] - dp[x1][m-1] + dp[x1][y1]), answer);
            }
        }

        // 유동적인 직사각형 잡기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long minFromThisPos = Math.max(dp[i][j] * (dp[n-1][j] - dp[i][j]) * (dp[n-1][m-1] - dp[n-1][j]),
                    dp[i][j] * (dp[i][m-1] - dp[i][j]) * (dp[n-1][m-1] - dp[i][m-1]));
                answer = Math.max(minFromThisPos, answer);
            }
        }

        System.out.println(answer);

    }
}
