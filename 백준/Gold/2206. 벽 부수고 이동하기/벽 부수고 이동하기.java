import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] grid;
    static int n;
    static int m;

    static int[][][] visited;
    static final int[][] DXYS = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line[j];
            }
        }

        int answer = bfs();

        System.out.println(answer);
    }

    private static int bfs() {
        Deque<Pos> dq = new ArrayDeque<>();
        dq.offer(new Pos(0,0, 0));

        visited = new int[n][m][2];
        visited[0][0][0] = 1;

        while (!dq.isEmpty()) {
            Pos cur = dq.poll();
            int cx = cur.x;
            int cy = cur.y;

            if (cx == n-1 && cy == m-1) {
                int noCrash = visited[n-1][m-1][0];
                int crash = visited[n-1][m-1][1];

                if (noCrash == 0) return crash;
                else if (crash == 0) return noCrash;
                else return Math.min(noCrash, crash);
            }

            for (int[] dxy : DXYS) {
                int nx = cx + dxy[0];
                int ny = cy + dxy[1];

                if (!canMove(nx, ny)) continue;
                if (grid[nx][ny] == '1' && visited[nx][ny][1] == 0 && cur.wallCrash == 0) {
                    visited[nx][ny][1] = visited[cx][cy][cur.wallCrash] + 1;
                    dq.offer(new Pos(nx, ny, 1));
                } else if (grid[nx][ny] == '0' && visited[nx][ny][cur.wallCrash] == 0) {
                    visited[nx][ny][cur.wallCrash] = visited[cx][cy][cur.wallCrash] + 1;
                    dq.offer(new Pos(nx, ny, cur.wallCrash));
                }

            }
        }

        return -1;
    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}



class Pos {
    int x;
    int y;
    int wallCrash;

    public Pos(int x, int y, int wallCrash) {
        this.x = x;
        this.y = y;
        this.wallCrash = wallCrash;
    }
}