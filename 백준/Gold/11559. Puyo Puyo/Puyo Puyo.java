import java.io.*;
import java.util.*;

public class Main {
    static final int GRID_WIDTH = 6;
    static final int GRID_HEIGHT = 12;
    static int answer = 0;
    static boolean[][] visited;
    static char[][] grid = new char[GRID_HEIGHT][GRID_WIDTH];
    static final int[][] DXYS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < GRID_HEIGHT; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < GRID_WIDTH; j++) {
                grid[i][j] = line[j];
            }
        }

        while (true) {
            visited = new boolean[GRID_HEIGHT][GRID_WIDTH];
            boolean flag = false;
            for (int x = 0; x < GRID_HEIGHT; x++) {
                for (int y = 0; y < GRID_WIDTH; y++) {
                    if (grid[x][y] != '.' && !visited[x][y]) {
                        visited[x][y] = true;
                        if (puyo(x, y)) flag = true;
                    }
                }
            }
            if (flag) answer += 1;
            else break;

            fallingDown();
        }

        System.out.println(answer);
    }

    private static boolean puyo(int x, int y) {
        char color = grid[x][y];
        Deque<Pos> dq = new ArrayDeque<>();
        Pos startPos = new Pos(x, y);
        dq.offer(startPos);
        List<Pos> path = new ArrayList<>();
        path.add(startPos);

        while (!dq.isEmpty()) {
            Pos curPos = dq.poll();

            for (int[] dxy : DXYS) {
                int nx = curPos.x + dxy[0];
                int ny = curPos.y + dxy[1];
                if (!canMove(nx, ny)) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] != color) continue;
                visited[nx][ny] = true;
                path.add(new Pos(nx, ny));
                dq.offer(new Pos(nx, ny));
            }
        }

        if (path.size() >= 4) {
            for (Pos pos : path) {
                grid[pos.x][pos.y] = '.';
            }
            return true;
        }
        return false;
    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < GRID_HEIGHT && 0 <= y && y < GRID_WIDTH;
    }

    private static void fallingDown() {
        for (int y = 0; y < GRID_WIDTH; y++) {
            int downX = GRID_HEIGHT - 1;
            while (downX >= 0) {
                if (grid[downX][y] == '.') {
                    int upperX = downX;
                    while (upperX >= 0) {
                        if (grid[upperX][y] != '.') {
                            grid[downX][y] = grid[upperX][y];
                            grid[upperX][y] = '.';
                            break;
                        }
                        upperX--;
                    }
                }
                downX--;
            }
        }
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