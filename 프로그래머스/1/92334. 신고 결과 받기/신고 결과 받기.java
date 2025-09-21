import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 누가 누구를 신고했는지 저장 필요
        
        Map<String, Integer> userIdxMapping = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            userIdxMapping.put(id_list[i], i);
        }
        
        Map<String, Set<String>> reporterMapping = new HashMap<>();
        
        for (String reportRawData : report) {
            String[] finedData = reportRawData.split(" ");
            String reporter = finedData[0];
            String warnedUser = finedData[1];
            Set<String> reporters = reporterMapping.getOrDefault(warnedUser, new HashSet<String>());
            reporters.add(reporter);
            reporterMapping.put(warnedUser, reporters);
        }
        
        // 중복된 신고가 들어올 수 있지만 (신고자, 피신고자) 쌍으로 멱등성키로 주어져있다. 따라서 몇번이든 상관없이 1로 처리된다.
        for (String warnedUser : reporterMapping.keySet()) {
            Set<String> reporters = reporterMapping.get(warnedUser);
            if (reporters.size() < k) continue;

            for (String reporter: reporters) {
                int idx = userIdxMapping.get(reporter);
                answer[idx]++;
            }
        }
        
        return answer;
    }
}