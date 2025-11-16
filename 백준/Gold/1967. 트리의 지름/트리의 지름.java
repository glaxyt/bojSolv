import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int max = 0;
    static int maxId = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 트리의 지름 문제
        //

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = info[0];
            int b = info[1];
            int cost = info[2];

            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n+1];
        visited[maxId] = true;
        dfs(maxId, 0);

        System.out.println(max);
    }

    public static void dfs(int s, int result) {
        if (result > max) {
            maxId = s;
            max = result;
        }

        for (Node nx : graph.get(s)) {
            if (!visited[nx.id]) {
                visited[nx.id] = true;
                dfs(nx.id, result + nx.cost);
            }
        }
    }
}

class Node {
    int id;
    int cost;

    public Node(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }
}
