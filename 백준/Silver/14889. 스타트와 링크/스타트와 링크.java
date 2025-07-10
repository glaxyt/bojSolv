import java.io.IOException;
import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        grid = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }

        backtracking(0, 0);

        System.out.println(answer);

    }

    public static void backtracking(int start, int cnt) {
        if (cnt == n / 2) {
            compare_abillity();
            return;
        }

        for (int i = start; i < n; i++) {
            // 선택하지않았다면
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void compare_abillity() {
        int starTeamPower = 0;
        int linkTeamPower = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) starTeamPower += grid[i][j] + grid[j][i];
                else if (!visited[j] && !visited[i]) linkTeamPower += grid[i][j] + grid[j][i];
            }
        }

        answer = Math.min(answer, Math.abs(starTeamPower - linkTeamPower));
    }
}
