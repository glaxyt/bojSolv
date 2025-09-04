import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // KIST 기사단 N명의 집이 있는 노드 번호
        // KIST, 씨알푸드의 노드 번호
        // 한 사람의 거리 di = (집-KIST의 최단 거리) + (집-씨알푸드의 최단 거리)
        // 도달할 수 없는 경우의 최단 거리는 -1로 정의
        // 주어진 기사단의 총 거리 합을 계산하는 것이 목표

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int v = input[1];
        int e = input[2];

        graph = new int[v+1][v+1];
        int[] targetNodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int kistNode = targetNodes[0];
        int crFoodNode = targetNodes[1];

        List<Integer> teammateNodes = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int answer = 0;
        for (int i = 0; i < e; i++) {
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = data[0];
            int b = data[1];
            int w = data[2];
            graph[a][b] = w;
            graph[b][a] = w;
        }

        for (int teammateNode : teammateNodes) {
            answer += dijkstra(v, teammateNode, kistNode, crFoodNode);
        }

        System.out.println(answer);
    }

    private static int dijkstra(int v, int teamHomeNode, int kist, int food) {
        int result = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> Integer.compare(a.weight, b.weight));
        pq.offer(new Node(teamHomeNode, 0));
        int[] dis = new int[v+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[teamHomeNode] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (curNode.weight > dis[curNode.id]) continue;

            for (int nextNodeId = 1; nextNodeId <= v; nextNodeId++) {
                int weight = graph[curNode.id][nextNodeId];
                if (weight == 0) continue;

                int newWeight = weight + curNode.weight;
                if (newWeight < dis[nextNodeId]) {
                    dis[nextNodeId] = newWeight;
                    pq.offer(new Node(nextNodeId, newWeight));
                }
            }
        }

        if (dis[food] == Integer.MAX_VALUE) result += -1;
        else result += dis[food];

        if (dis[kist] == Integer.MAX_VALUE) result += -1;
        else result += dis[kist];

        return result;
    }
}

class Node {
    int id;
    int weight;

    public Node(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
}