import java.util.*;

// 14시 37분 시작.
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] answer = new int[4];
    public int[] solution(int[][] edges) {
        // 도넛 모양 그래프
        // 다시 돌아오는 방법은 없고, 이용한적없는 간선만을 타고 가다 보면 다시 시작한 지점으로 돌아와야한다. 대신 정점은 n-1개의 정점이어야한다.
        
        // 막대 모양 그래프
        // 따라가다보면 한번씩 방문하는 정점이 단 하나 존재. 따라서 간선을 한번만 사용한다고 할때, 방문했던 정점을 다시 방문하면 문제다.
        
        // 8자 모양 그래프
        // 도넛 모양의 그래프를 2개 합친 모양.
        
        // 노드의 번호는 1부터 주어진다.
        // 그래프의 개수를 파악해서 나한테 알려주라는 얘기네
        
        // 생성 정점을 찾아야한다.
        // 생성 정점의 기준은 들어오는 간선이 없어야한다. 이게 기준이네. 다른 정점은 모두 돌아오는 간선이 존재할 수 있다.
        // 무조건 나가야하는 간선만 존재해야한다.
        // 미리 찾을 수 있을까?
        
        // 정점의 개수는 몇개인가?
        // 최대치를 알아야한다.
        int nodeCnt = 0;
        for (int[] data : edges) {
            nodeCnt = Math.max(Math.max(nodeCnt, data[0]), data[1]);
        }
            
        for (int i = 0; i <= nodeCnt; i++) {
            graph.add(new ArrayList<>());
        }
        
        Set<Integer> startNode = new HashSet<>();
        Set<Integer> endNode = new HashSet<>();
        
        for (int[] data : edges) {
            int start = data[0];
            int end = data[1];
            graph.get(start).add(end);
            startNode.add(start);
            endNode.add(end);
        }
        
        for (int end : endNode) startNode.remove(end);
        
        int initialNode = 0;
        for (int node : startNode) {
            if (graph.get(node).size() > 1) {
                initialNode = node;
                answer[0] = initialNode;
                break;
            }
        }
        
        // 시작 정점 찾아보고 찾으면 거기부터 순회 시작.
        // 모든 정점 순회는 안된다 데이터 전처리 때부터 걸러내야한다.
        for (int next : graph.get(initialNode)) {
            bfs(nodeCnt, next);
        }
        
        return answer;
    }
    
    private static void bfs(int n, int start) {
        // 여기서 어떤 그래프인지 파악을 어떻게 할 수 있을까?
        // 막대는 안돌아온다. 안돌아온다면 그것은 막대.
        // 만일 Edge가 여러개라면 높은 확률로 8자 그래프다.
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        boolean canBeDonut = false;
        boolean canBeEight = false;
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            
            List<Integer> nextNodes = graph.get(cur);
            if (nextNodes.size() > 1) {
                answer[3]++;
                return;
            }
            
            for (int next : nextNodes) {

                if (visited[next]) {
                    if (next == start) {
                        canBeDonut = true;
                    }
                    continue;
                }
                
                dq.offer(next);
                visited[next] = true;
            }
        }
        
        if (canBeDonut) answer[1]++;
        else answer[2]++;
    }
}