import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        // 백트래킹 쓸까
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return answer;
    }
    
    public void dfs(int[][] dungeons, int pirodo, int cnt) {
        
        if (answer < cnt) {
            answer = cnt;
        }
        
        for (int idx = 0; idx < dungeons.length; idx++) {
            int need = dungeons[idx][0], getpiro = dungeons[idx][1];
            
            if (!visited[idx] && pirodo >= need) {
                visited[idx] = true;
                dfs(dungeons, pirodo - getpiro, cnt + 1);
                visited[idx] = false;
            }
        }
    }
}