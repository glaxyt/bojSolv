import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int answer = 0;
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i);
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int s) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(s);
        visited[s] = true;

        while (!dq.isEmpty()) {
            Integer cur = dq.poll();

            for (int nx : graph.get(cur)) {
                if (!visited[nx]) {
                    visited[nx] = true;
                    dq.offer(nx);
                }
            }

        }
    }
}
