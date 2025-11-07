import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // {sCnt, wCnt}
    static int[] answer = new int[2];
    static int[][] DXYS = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    static String[] grid;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빈공간을 찾고, 그 부분에서 범위 탐색을 수행한다 그러면 전역 방문체크가 필요,
        // 양도 늑대를 먹을 수 있다.
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        visited = new boolean[n][m];
        grid = new String[n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            grid[i] = line;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) != '#' && !visited[i][j]) {
                    findWolfAndSheep(i, j);
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    private static void findWolfAndSheep(int sx, int sy) {
        visited[sx][sy] = true;
        Deque<Pos> dq = new ArrayDeque<>();
        dq.offer(new Pos(sx, sy));
        int sCnt = 0;
        int wCnt = 0;

        if (grid[sx].charAt(sy) == 'k') sCnt++;
        else if (grid[sx].charAt(sy) == 'v') wCnt++;

        while (!dq.isEmpty()) {
            Pos cur = dq.poll();

            for (int[] dxy : DXYS) {
                int nx = cur.x + dxy[0];
                int ny = cur.y + dxy[1];

                if (!canMove(nx, ny)) continue;
                if (visited[nx][ny]) continue;

                char who = grid[nx].charAt(ny);
                if (who == '#') continue;

                if (who == 'v') wCnt++;
                else if (who == 'k') sCnt++;

                visited[nx][ny] = true;
                dq.offer(new Pos(nx, ny));
            }
        }

        if (sCnt > wCnt) {
            answer[0] += sCnt;
        } else {
            answer[1] += wCnt;
        }
    }

    private static boolean canMove(int x, int y) {
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
