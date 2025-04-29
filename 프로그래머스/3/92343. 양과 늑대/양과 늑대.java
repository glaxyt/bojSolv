import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static int answer = 0;
    public int solution(int[] info, int[][] edges) {
        graph = new ArrayList[info.length];
        
        for (int[] edge : edges) {
            int px = edge[0];
            int cx = edge[1];
            if (graph[px] == null) {
                graph[px] = new ArrayList<Integer>();
            }
            graph[px].add(cx);
        }    
        List<Integer> nextPositions = new ArrayList<>();
		nextPositions.add(0);
        
        dfs(0, 0, 0, nextPositions, info);
        
        return answer;
    }
    
    public void dfs(int cx, int s, int w, List<Integer> nextPositions, int[] info) {
        if (info[cx] == 1) {
            w++;
        } else {
            s++;
            answer = Math.max(answer, s);
        }
        
        if (s <= w) {
            return;
        }
        
        List<Integer> newNextPositions = new ArrayList<>(nextPositions);
        newNextPositions.remove(Integer.valueOf(cx));        
        
        if (graph[cx] != null) {
            for (int childNode : graph[cx]) {
                newNextPositions.add(childNode);
            }
        }
        
        for (int nx : newNextPositions) {
            dfs(nx, s, w, newNextPositions, info);
        }

    }
}