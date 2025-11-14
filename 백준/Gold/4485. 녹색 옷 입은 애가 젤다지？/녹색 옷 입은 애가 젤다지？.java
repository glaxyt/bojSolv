import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[][] DYxS = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] grid = new int[n][n];

            for (int i=0; i<n; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j=0; j<n; j++) {
                    grid[i][j] = line[j];
                }
            }

            int[][] visited = new int[n][n];
            for (int i=0; i<n; i++) {
                Arrays.fill(visited[i], Integer.MAX_VALUE);
            }

            visited[0][0] = grid[0][0];

            Deque<Pos> dq = new ArrayDeque<>();
            dq.offer(new Pos(0, 0, grid[0][0]));

            while (!dq.isEmpty()) {
                Pos cur = dq.poll();

                if (visited[cur.x][cur.y] < cur.cost) continue;

                for (int[] dxy : DYxS) {
                    int nx = cur.x + dxy[0];
                    int ny = cur.y + dxy[1];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        int nCost = cur.cost + grid[nx][ny];
                        if (visited[nx][ny] > nCost) {
                            visited[nx][ny] = nCost;
                            dq.offer(new Pos(nx, ny, nCost));
                        }
                    }
                }
            }

            System.out.println("Problem " + t + ": " + visited[n-1][n-1]);
            t++;
        }
    }
}

class Pos {
    int x;
    int y;
    int cost;

    public Pos(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}