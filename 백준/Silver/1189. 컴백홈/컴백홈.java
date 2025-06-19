import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] grid;
    static boolean[][] visited;
    static int answer = 0;
    static int r;
    static int c;
    static int k;

    static class pos {
        private int x;
        private int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static pos[] dxys = {new pos(0, 1), new pos(0, -1), new pos(1, 0), new pos(-1, 0)};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r = input[0];
        c = input[1];
        k = input[2];

        grid = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        visited[r - 1][0] = true;
        backtrack(1, r - 1, 0);
        System.out.println(answer);
    }

    private static void backtrack(int cost, int rowNum, int colNum) {
        if (cost > k) {
            return;
        }

        if (cost == k && rowNum == 0 && colNum == c - 1) {
            answer++;
            return;
        }

        for (pos dxy : dxys) {
            int newX = rowNum + dxy.x;
            int newY = colNum + dxy.y;

            if (newX >= 0 && newX < r && newY >= 0 && newY < c) {
                if (grid[newX][newY] == 'T' || visited[newX][newY]) continue;

                visited[newX][newY] = true;
                backtrack(cost + 1, newX, newY);
                visited[newX][newY] = false;
            }
        }
    }
}