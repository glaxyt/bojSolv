import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] grid;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // F, S, G, U, D
        // F은 전체 층
        // S는 현재 층
        // G는 목표 층
        // U는 몇 층 이동인지
        // D는 몇 층아래로 이동인지

        // 적어도 몇번 눌러야하는지 구현

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int F = input[0];
        int S = input[1];
        int G = input[2];
        int U = input[3];
        int D = input[4];

        System.out.println(dfs(F, S, G, U, D));
    }

    private static String dfs(int F, int S, int G, int U, int D) {
        int[] visited = new int[F+1];
        visited[S] = 1;

        int[] move = new int[]{U, D * -1};

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(S);

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            if (cur == G) {
                return visited[cur] - 1 + "";
            }

            for (int m : move) {
                int next = cur + m;
                if (0 < next && next <= F && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    dq.offer(next);
                }
            }
        }

        return "use the stairs";
    }
}
