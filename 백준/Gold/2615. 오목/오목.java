import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int GRID_LEN = 19;
    static int[][] DXYS = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};
    static int[][] grid = new int[GRID_LEN][GRID_LEN];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 가장 왼쪽의 바둑알부터 계산해야한다.
        // 만일한다면 BFS로 탐색하면 충분할 것 같음
        // 1열부터 - n열까지 탐색 진행하면되지않을까?
        // 해당 열을 기준으로 한방향으로 쭉 가본다. 두번째열도 마찬가지로 한방향으로 쭉 나아가본다.
        // 6개가 되는건 성공했다고 보지않는다라고 했다. 그래서 나아가기 전에 직전 열에서 같은 색의 바둑알이 존재하는지 확인해야한다.
        // 가로와 대각선(/, \)일 경우. 세로는 제외.

        for (int i = 0; i < GRID_LEN; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < GRID_LEN; j++) {
                grid[i][j] = line[j];
            }
        }

        int[] answer = solve();

        if (answer[0] == 0) {
            System.out.println(0);
        } else {
            System.out.println(answer[0]);
            System.out.println(answer[1] + " " + answer[2]);
        }
    }

    private static int[] solve() {
        for (int y = 0; y < GRID_LEN; y++) {
            for (int x = 0; x < GRID_LEN; x++) {
                int color = grid[x][y];
                if (color == 0) continue;

                for (int dir = 0; dir < DXYS.length; dir++) {
                    int px = x - DXYS[dir][0];
                    int py = y - DXYS[dir][1];
                    if (isSameColor(px, py, color)) continue;

                    int cnt = 0;
                    int cx = x;
                    int cy = y;
                    while (canMove(cx, cy)) {
                        if (!(grid[cx][cy] == color)) break;
                        cnt++;

                        cx += DXYS[dir][0];
                        cy += DXYS[dir][1];
                    }

                    if (cnt == 5) return new int[]{color, x+1, y+1};
                }
            }
        }
        return new int[]{0,0,0};
    }

    private static boolean isSameColor(int px, int py, int color) {
        if (!canMove(px, py)) return false;

        if (color == grid[px][py]) return true;

        return false;
    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < GRID_LEN && 0 <= y && y < GRID_LEN;
    }

}