import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        
        for (int idx = 0; idx < wires.length; idx++) {
            List<Integer>[] graph = buildGraph(n, wires, idx);
            int result = bfs(graph, n, 1);
            int other = n - result;
            int difference = Math.abs(result - other);
            answer = Math.min(answer, difference);
        }
        return answer;
    }
    
    public List<Integer>[] buildGraph(int n, int[][] wires, int skipIdx) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            if (i == skipIdx) continue;

            int a = wires[i][0];
            int b = wires[i][1];

            graph[a].add(b);
            graph[b].add(a);
        }

        return graph;
    }

    
    public int bfs(List<Integer>[] graph, int n, int sx) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(sx);
        visited[sx] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int cx = q.poll();
            
            for (int next : graph[cx]) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt += 1;
                    q.offer(next);
                }
            }
        }
        return cnt;
    }
}