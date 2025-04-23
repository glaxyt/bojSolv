import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] clothe : clothes) {
            String kind = clothe[1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        
        // 이제 있는만큼 뽑을건데 2c1 * 2c1 * 1이 아니라, 
        // 있는만큼 뽑은거임
        // 우선 맵에 존재하는 만큼 더하기 + 이 중에서 2개 골라서 곱하기 
        // 3개골라서 곱하기 등등
        
        for (String kind : map.keySet()) {
            answer = answer * (map.get(kind) + 1);
        }
        return answer - 1;
    }
}