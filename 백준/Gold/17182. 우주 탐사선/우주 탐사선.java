import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] dis;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 모든행성을 탐색하는데 걸리는 시간.
        // 이 문제는 백트래킹과 플로이드 워셜을 사용해야하는 문제로 판단됨.
        // 근데 플로이드 워셜은 무조건적으로 적용하고 나서 계산해야하는가?
        // 그냥 이동시키자.
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int k = input[1];
        visited = new boolean[n];

        dis = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                dis[i][j] = line[j];
            }
        }

        for (int l = 0; l < n; l++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    dis[a][b] = Math.min(dis[a][b], dis[a][l] + dis[l][b]);
                }
            }
        }
        visited[k] = true;
        dfs(n, k, 1, 0);
        System.out.println(answer);
    }

    private static void dfs(int n, int cur, int cnt, int cost) {
        if (cnt == n) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int next = 0; next < n; next++) {
            if (cur == next) continue;
            if (visited[next]) continue;
            visited[next] = true;
            dfs(n, next, cnt+1, cost+dis[cur][next]);
            visited[next] = false;
        }
    }
}
