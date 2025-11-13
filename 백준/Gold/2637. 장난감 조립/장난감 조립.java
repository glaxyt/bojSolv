import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] DXYS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] parts;
    static int[][] partResult;
    static boolean[] basic;
    static int[] indegree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parts = new int[n+1][n+1];
        indegree = new int[n+1];
        partResult = new int[n+1][n+1];
        basic = new boolean[n+1];

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(line[1]).add(line[0]);
            parts[line[0]][line[1]] = line[2];
            indegree[line[0]]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                dq.offer(i);
                basic[i] = true;
                partResult[i][i] = 1;
            }
        }

        while (!dq.isEmpty()) {
            Integer cur = dq.poll();

            for (Integer nx : graph.get(cur)) {
                indegree[nx]--;

                if (indegree[nx] == 0) {
                    dq.offer(nx);

                    for (int i = 0; i <= n; i++) {
                        if (parts[nx][i] != 0) {
                            for (int j = 0; j <= n; j++) {
                                partResult[nx][j] += (partResult[i][j] * parts[nx][i]);
                            }
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (basic[i]) System.out.println(i + " " + partResult[n][i]);
        }

        // System.out.println(Arrays.toString(partResult[n]));

    }
}
