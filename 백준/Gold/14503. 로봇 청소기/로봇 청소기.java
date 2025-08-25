import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] gridData = br.readLine().split(" ");
        int n = Integer.parseInt(gridData[0]);
        int m = Integer.parseInt(gridData[1]);

        String[] robotData = br.readLine().split(" ");
        int r = Integer.parseInt(robotData[0]);
        int c = Integer.parseInt(robotData[1]);
        int d = Integer.parseInt(robotData[2]);

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }

        int cx = r;
        int cy = c;
        int cdir = d;

        while (true) {
            if (grid[cx][cy] == 0) {
                grid[cx][cy] = 2;
                answer++;
            }

            boolean flag = true;
            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (canMove(n, m, nx, ny) && grid[nx][ny] == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                int nx = cx - dirs[cdir][0];
                int ny = cy - dirs[cdir][1];
                if (canMove(n, m, nx, ny) && grid[nx][ny] != 1) {
                    cx = nx;
                    cy = ny;
                } else {
                    break;
                }
            }
            else {
                for (int i = 0; i < 4; i++) {
                    cdir = (cdir + 3) % 4;
                    int nx = cx + dirs[cdir][0];
                    int ny = cy + dirs[cdir][1];
                    if (canMove(n, m, nx, ny) && grid[nx][ny] == 0) {
                        cx = nx;
                        cy = ny;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean canMove(int n, int m, int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}