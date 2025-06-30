import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] a;
    static boolean[][] visited;
    static Pos[] dir = {new Pos(0, -1), new Pos(-1, -1), new Pos(-1, 0), new Pos(-1, 1), new Pos(0, 1), new Pos(1, 1), new Pos(1, 0), new Pos(1, -1)};
    static Pos[] diagonal = {new Pos(1, 1), new Pos(1, -1), new Pos(-1, 1), new Pos(-1, -1)};
    static class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = input[0];
        m = input[1];

        a = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                a[i][j] = row[j];
            }
        }

        // 초기 구름 위치 지정
        visited[n-1][0] = true;
        visited[n-1][1] = true;
        visited[n-2][0] = true;
        visited[n-2][1] = true;

        while (m-- > 0) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int d = input[0] - 1;
            int s = input[1];

            move_cloud(d, s);

            create_cloud();

        }


        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalWater += a[i][j];
            }
        }
        System.out.println(totalWater);

    }

    private static void move_cloud(int d, int s) {
        boolean[][] newVisited = new boolean[n][n];
        // visited 를 어디에 구름이 머물고 있는지 계산: 구름이 머물고 있는 칸은 물이 1씩 증가.
        for (int curX = 0; curX < n; curX++) {
            for (int curY = 0; curY < n; curY++) {
                if (visited[curX][curY]) {
                    int newX = (curX + dir[d].x * s % n + n) % n;
                    int newY = (curY + dir[d].y * s % n + n) % n;
                    newVisited[newX][newY] = true;
                    a[newX][newY] += 1;
                }
            }
        }

        // 머물고 있는 곳을 기반으로 빗물 계산: 물복사 버그
        for (int curX = 0; curX < n; curX++) {
            for (int curY = 0; curY < n; curY++) {
                if (newVisited[curX][curY]) {
                    calculate_water_from_cloud(curX, curY);
                }
            }
        }
        visited = newVisited;
    }

    // 물복사 버그
    private static void calculate_water_from_cloud(int x, int y) {
        // 주변 빗물을 계산하고 빗물 추가
        int total = 0;

        for (int i = 0; i < 4; i++) {
            int newX = x + diagonal[i].x;
            int newY = y + diagonal[i].y;
            if (0 <= newX && newX < n && 0 <= newY && newY < n && a[newX][newY] > 0) total++;
        }

        a[x][y] += total;
    }

    private static void create_cloud() {
        // 구름을 생성할 수 있는 공간을 확인
        // 이전에 구름이 머물렀던 공간은 구름을 생성할 수 없음
        for (int curX = 0; curX < n; curX++) {
            for (int curY = 0; curY < n; curY++) {
                if (!visited[curX][curY]) {
                    if (a[curX][curY] >= 2) {
                        visited[curX][curY] = true;
                        a[curX][curY] -= 2;
                    }
                } else visited[curX][curY] = false;
            }
        }
    }
}
