import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 다음 달에 누가 더많은 선물을 받을지 찾는 문제
        // A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 준다면 '다음달'에 A는 B에게 선물을 받는다.
        // 두 사람 사이에 선물 기록이 없거나 주고 받은 수가 같다면, 선물 지수가 높은 사람이 작은 사람에게 선물을 받는다.
        // 선물 지수란?
        // '이번 달'까지 자신이 친구들에게 준 선물 - 받은 선물 의 값.
        // 그렇다면 친구들에게 선물을 많이 준 애는 선물을 받는다.
        // 선물지수도 같다면 선물 주고받지않는다.
        int len = friends.length;
        Map<String, Integer> nameIdxMapper = new HashMap<>();
        for (int i = 0; i < len; i++) {
            nameIdxMapper.put(friends[i], i);
        }
        
        Map<String, Integer> pointMap = new HashMap<>();
        int[][] grid = new int[len][len];
        
        // 다음주 선물을 가장 많이 받을 친구가 받는 선물의 수를 찾기
        for (String gift : gifts) {
            String[] parsingGift = gift.split(" ");
            String sender = parsingGift[0];
            String reciever = parsingGift[1];
            grid[nameIdxMapper.get(sender)][nameIdxMapper.get(reciever)] += 1;
            
            pointMap.put(sender, pointMap.getOrDefault(sender, 0) + 1);
            pointMap.put(reciever, pointMap.getOrDefault(reciever, 0) - 1);
        }
        
        
        for (int idx = 0; idx < friends.length; idx++) {
            String me = friends[idx];
            int point = pointMap.getOrDefault(me, 0);
            int result = 0;
            for (String friend : friends) {
                if (me.equals(friend)) continue;
                
                if (grid[nameIdxMapper.get(me)][nameIdxMapper.get(friend)] > grid[nameIdxMapper.get(friend)][nameIdxMapper.get(me)]) {
                    result++;
                } else if (grid[nameIdxMapper.get(me)][nameIdxMapper.get(friend)] == grid[nameIdxMapper.get(friend)][nameIdxMapper.get(me)]) {
                    int friendPoint = pointMap.getOrDefault(friend, 0);
                    if (point > friendPoint) result++;
                }
                // 선물 못받거나 기록이 같은 애들끼리 대결.               
            }

            answer = Math.max(answer, result);
        }
        
        return answer;
    }
}