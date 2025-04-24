import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int cnt = 0;
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        
        for (int[] cost : costs) {
            int a = cost[0], b = cost[1], c = cost[2];
            if (find(parents, a) != find(parents, b)) {
                union(parents, a, b);
                cnt++;
                answer += c;
                if (cnt == n-1) return answer;
            }
        }
        
        return answer;        
    }
    
    public int find(int[] parents, int x) {
        if (parents[x] == x) return x;
        
        return parents[x] = find(parents, parents[x]);
    }
    
    public void union(int[] parents, int a, int b) {
        int parentA = find(parents, a);
        int parentB = find(parents, b);
        
        parents[parentB] = parentA;
    }
}