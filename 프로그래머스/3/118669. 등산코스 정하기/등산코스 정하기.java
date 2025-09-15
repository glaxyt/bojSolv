import java.util.*;

class Solution {
    static List<List<Edge>> graph = new ArrayList<>();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 산봉우리를 찍고 오는데 휴식시간이 가장 짧은 코스를 찾으려고 하고 있고,
        // 만일 여러개라면 가장낮은 등산코스부터한다.
        // 산봉우리를 하나 정하고, 입구를 정하고
        // 그 외의 산봉우리와 입구는 모두 DIS를 높인다.
        // 최단거리가 중요한가? 중요하지않다. 재방문을 해도 된다. 이 기준 아래에서는 최단거리로 계산하는게 맞는가?
        // 최단거리를 찾는 것이 Intensity를 만들어내는 것으로 귀결되는가?
        // 12 6 으로 도착한 곳과 7 7로 도착한 곳은 최단거리는 앞의 것이 짧지만 문제에서 찾는 것은 후자이다.
        
        // 노드는 1부터 시작
        for (int i = 0; i < n+1; i++) graph.add(new ArrayList<>());
        
        for (int i = 0; i < paths.length; i++) {
            int[] path = paths[i];
            int a = path[0];
            int b = path[1];
            int c = path[2];
            graph.get(a).add(new Edge(a, b, c));
            graph.get(b).add(new Edge(b, a, c));
        }
        
        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> summitSet = new HashSet<>();
        
        for (int node : gates) gateSet.add(node);
        for (int node : summits) summitSet.add(node);
        
        int[] answer = dijkstra(n, gateSet, summitSet);
        return answer;
    }
    
    private static int[] dijkstra(int n, Set<Integer> gateSet, Set<Integer> summitSet) {        
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) ->
            Integer.compare(a.maxCost, b.maxCost)
        );
                
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        for (Integer node : gateSet) {
            intensity[node] = 0;
            pq.offer(new Node(node, Integer.MIN_VALUE));
        }

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cNodeId = curNode.id;
            int maxCost = curNode.maxCost;
            
            if (maxCost > intensity[cNodeId]) continue;
            
            if (summitSet.contains(cNodeId)) continue;
                   
            for (Edge e : graph.get(cNodeId)) {
                int nextNode = e.nextNode;
                int newMaxCost = Math.max(maxCost, e.cost);
                
                if (intensity[nextNode] > newMaxCost) {
                    pq.offer(new Node(nextNode, newMaxCost));
                    intensity[nextNode] = newMaxCost;
                }
            }
        }
                
        int goalSummit = -1;
        int shortestIntensity = Integer.MAX_VALUE;
        for (Integer summit : summitSet) {
            int curIntensity = intensity[summit];
            if (shortestIntensity > curIntensity) {
                goalSummit = summit;
                shortestIntensity = curIntensity;
            } else if (shortestIntensity == curIntensity && goalSummit > summit) {
                goalSummit = summit;
                shortestIntensity = curIntensity;
            }
        }
        
        return new int[]{goalSummit, shortestIntensity};
    }
}

class Node {
    int id;
    int maxCost;
    
    public Node(int id, int maxCost) {
        this.id = id;
        this.maxCost = maxCost;
    }
}

class Edge {
    int preNode;
    int nextNode;
    int cost;
    
    public Edge(int preNode, int nextNode, int cost) {
        this.preNode = preNode;
        this.nextNode = nextNode;
        this.cost = cost;
    }
}