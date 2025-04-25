import java.util.*;

class Solution {
    
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 고르기 
        char[] nums = numbers.toCharArray();
        visited = new boolean[nums.length];
        for (int idx = 1; idx <= numbers.length(); idx++) {
            System.out.println(idx);
            backtracking(nums, "", 0, idx);
        }
        
        return set.size();
    }
    
    public void backtracking(char[] nums, String temp, int cnt, int limit) {
        if (cnt == limit) {
            int result = Integer.parseInt(temp);
            if (isSosu(result)) {
                set.add(result);
            }
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(nums, temp + nums[i], cnt + 1, limit);
                visited[i] = false;
            }
        }
    }
    
    public boolean isSosu(int n) {
        if (n < 2) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}