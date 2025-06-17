import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class pos {
        public int x;
        public int y;
        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] grid = new boolean[101][101];
    static pos[] dir = {new pos(1, 0), new pos(0, -1), new pos(-1, 0), new pos(0, 1)};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int answer = 0;
        while (t-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = input[0];
            int y = input[1];
            int d = input[2];
            int g = input[3];
            grid[y][x] = true;
            int end_y = y + dir[d].y;
            int end_x = x + dir[d].x;
            grid[end_y][end_x] = true;
            List<Integer> dirHistory = new ArrayList<>();
            dirHistory.add(d);
            // 1세대 이상만 작동한다.
            int lineCnt = 1;
            while (g > 0) {
                for (int i = lineCnt - 1; i >= 0; i--) {
                    int pastDirIdx = dirHistory.get(i);
                    int rotateDirIdx = (pastDirIdx + 1) % 4;
                    pos pastDir = dir[rotateDirIdx];
                    end_y += pastDir.y;
                    end_x += pastDir.x;
                    grid[end_y][end_x] = true;
                    dirHistory.add(rotateDirIdx);
                }
                g--;
                lineCnt *= 2;
            }
        }

        for (int i = grid.length - 1; i > 0; i--) {
            for (int j = 0; j < grid.length - 1; j++) {
                if (grid[i][j] && grid[i][j+1] && grid[i-1][j] && grid[i-1][j+1]) answer++;
            }
        }

        System.out.println(answer);
    }
}
