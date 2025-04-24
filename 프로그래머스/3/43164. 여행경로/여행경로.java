import java.util.*;

class Solution {
    public static ArrayList<String> list = new ArrayList<>();
    public static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        // 항상 인천에서 출발.
        // 어떤 자료구조로 관리해야하는가.
//         Map<String, List<String>> map = new HashMap<>();
        
//         for (String[] ticket : tickets) {
//             map.putIfAbsent(ticket[0], new ArrayList<>());
//             map.get(ticket[0]).add(ticket[1]);
//         }
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    public void dfs(String start, String path, int cnt, String[][] tickets) {
        if (cnt == tickets.length) {
            list.add(path);
            return;
        }
        
        for (int idx = 0; idx < tickets.length; idx++) {
            String depart = tickets[idx][0];
            String landing = tickets[idx][1];
            if (depart.equals(start) && !visited[idx]) {
                visited[idx] = true;
                dfs(landing, path + " " + landing, cnt + 1, tickets);
                visited[idx] = false;
            }
        }
    }
}