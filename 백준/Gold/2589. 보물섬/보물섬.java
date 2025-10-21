import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] graph;
    static final int[][] DXYS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        graph = new char[n][m];
        for (int x = 0; x < n; x++) {
            char[] line = br.readLine().toCharArray();
            for (int y = 0; y < m; y++) {
                graph[x][y] = line[y];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (graph[x][y] == 'L') {
                    answer = Math.max(answer, bfs(n, m, x, y));
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int n, int m, int sx, int sy) {
        int result = 0;
        int[][] visited = new int[n][m];
        visited[sx][sy] = 1;
        Deque<Pos> dq = new ArrayDeque<>();
        dq.offer(new Pos(sx, sy));

        while (!dq.isEmpty()) {
            Pos cur = dq.poll();

            for (int[] dxy : DXYS) {
                int nx = cur.x + dxy[0];
                int ny = cur.y + dxy[1];

                if (!canMove(n, m, nx, ny)) continue;
                if (visited[nx][ny] != 0) continue;
                if (graph[nx][ny] == 'W') continue;

                visited[nx][ny] = visited[cur.x][cur.y] + 1;
                result = Math.max(result, visited[nx][ny]);
                dq.offer(new Pos(nx, ny));
            }
        }

        return result - 1;
    }

    private static boolean canMove(int n, int m, int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
