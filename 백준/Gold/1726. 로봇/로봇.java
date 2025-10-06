import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final Map<Integer, Integer> DIR = Map.of(1, 0, 2, 1, 3, 2, 4, 3);
    static final int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 궤도 내에 갈 수 있는 모든 곳을 탐색한다.
        // 가장 적은 명령어를 가진애들을 먼저 기준으로 수행해준다.
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[][] grid = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= m; j++) {
                grid[i][j] = line[j-1];
            }
        }

        int[] startData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] finalData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int startDir = toIndex(startData[2]);
        int finalDir = toIndex(finalData[2]);

        boolean[][][] visited = new boolean[n+1][m+1][4];
        visited[startData[0]][startData[1]][startDir] = true;
        pq.offer(new Node(startData[0], startData[1], startDir, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dirIdx = node.dir;
            int x = node.x;
            int y = node.y;
            int cost = node.cost;

            if (x == finalData[0] && y == finalData[1] && dirIdx == finalDir) {
                System.out.println(cost);
                return;
            }

            for (int k = 1; k <= 3; k++) {
                int nx = x + DIRS[dirIdx][0] * k;
                int ny = y + DIRS[dirIdx][1] * k;

                if (!canMove(n, m, nx, ny) || grid[nx][ny] == 1) break;
                if (visited[nx][ny][dirIdx]) continue;

                visited[nx][ny][dirIdx] = true;
                pq.offer(new Node(nx, ny, dirIdx, cost + 1));
            }

            for (int turn : new int[]{1, -1}) {
                int newDir = ((dirIdx + turn) % 4 + 4) % 4;
                if (visited[x][y][newDir]) continue;
                visited[x][y][newDir] = true;
                pq.offer(new Node(x, y, newDir, cost + 1));
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int toIndex(int dir) {
        if (dir == 1) return 0;
        if (dir == 3) return 1;
        if (dir == 2) return 2;
        return 3;
    }

    private static boolean canMove(int n, int m, int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m;
    }
}

class Node {
    int x;
    int y;
    int dir;
    int cost;

    public Node(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}