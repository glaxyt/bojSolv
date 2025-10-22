import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] grid;
    static int answer = 0;
    static int n;
    static int m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        grid = new boolean[n][m];

        dfs(0);  // main의 for문 제거하고 한 번만 호출

        System.out.println(answer);
    }

    private static void dfs(int cnt) {
        if (cnt == n * m) {
            answer++;
            return;
        }

        int x = cnt / m;
        int y = cnt % m;

        // 2x2 체크: 현재 위치에 놓으면 2x2가 되는지
        if (x > 0 && y > 0 && grid[x-1][y] && grid[x][y-1] && grid[x-1][y-1]) {
            // 2x2가 되므로 놓지 않음
            dfs(cnt + 1);
        } else {
            // 놓지 않는 경우
            dfs(cnt + 1);
            
            // 놓는 경우
            grid[x][y] = true;
            dfs(cnt + 1);
            grid[x][y] = false;
        }
    }
}