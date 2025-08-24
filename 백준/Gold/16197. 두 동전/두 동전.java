import java.io.*;
import java.util.*;

public class Main {
    static int[][] dxys = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static List<String> grid = new ArrayList<>();
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        n = input[0];
        m = input[1];
        List<int[]> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            grid.add(line);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'o') {
                    pos.add(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[n+1][m+1];
        dfs(visited, pos.get(0)[0], pos.get(0)[1], pos.get(1)[0], pos.get(1)[1], 0);

        if (answer > 10) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void dfs(boolean[][] visited, int sx1, int sy1, int sx2, int sy2, int cost) {
        if (cost > 10) return;

        if ((!canMove(sx1, sy1) && !canMove(sx2, sy2))) return;

        if ((canMove(sx1, sy1) && !canMove(sx2, sy2)) || (!canMove(sx1, sy1) && canMove(sx2, sy2))) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int[] dxy : dxys) {
            int nx1 = sx1 + dxy[0];
            int ny1 = sy1 + dxy[1];
            int nx2 = sx2 + dxy[0];
            int ny2 = sy2 + dxy[1];

            if (canMove(nx1, ny1) && visited[nx1][ny1] || canMove(nx2, ny2) && visited[nx2][ny2]) continue;

            if (canMove(nx1, ny1) && canMove(nx2, ny2) && grid.get(nx1).charAt(ny1) == '#' && grid.get(nx2).charAt(ny2) == '#') continue;

            if (canMove(nx1, ny1) && grid.get(nx1).charAt(ny1) == '#') {
                dfs(visited, sx1, sy1, nx2, ny2, cost + 1);
            } else if (canMove(nx2, ny2) && grid.get(nx2).charAt(ny2) == '#') {
                dfs(visited, nx1, ny1, sx2, sy2, cost + 1);
            } else {
                dfs(visited, nx1, ny1, nx2, ny2, cost + 1);
            }
        }

    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
