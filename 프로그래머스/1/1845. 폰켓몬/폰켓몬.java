import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (Integer num : nums) {
            String numToString = String.valueOf(num);
            map.put(numToString, map.getOrDefault(numToString, 0) + 1);
        }
        
        int canPickNum = nums.length / 2;
        int curPickNum = map.keySet().size();
        if (map.keySet().size() >= canPickNum) {
            return canPickNum;
        } else {
            return curPickNum;
        }
    }
}