import java.util.*;

class Solution {
    static List<Integer> selected = new ArrayList<>();
    static HashSet<Integer> fields = new HashSet<>();
    public int solution(String[][] relation) {
        int answer = 0;
        dfs(relation[0].length, 0, relation);
        
        for (Integer t : fields) {
            boolean isLeast = true;
            for (Integer l : fields) {
                if (t == l) continue;
                
                if ((t & l) == l) {
                    isLeast = false;
                    break;
                }
            }
            
            if (isLeast) {
                answer++;
            }
        }
        return answer;
    }
    
    private static void dfs(int n, int start, String[][] relation) {
        // 각 필드를 선택하고 필드 조합을 골라서 중복된 내용이 존재하는지 확인.
        calc(relation);
        
        for (int i = start; i < n; i++) {
            selected.add(i);
            dfs(n, i + 1, relation);
            selected.remove(selected.size() - 1);
        }
    }
    
    private static void calc(String[][] relation) {
        Set<String> set = new HashSet<>();
        
        for (int rIdx = 0; rIdx < relation.length; rIdx++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < selected.size(); i++) {
                sb.append(relation[rIdx][selected.get(i)]);
            }
            
            String compl = sb.toString();
            if (set.contains(compl)) {
                return;
            }
            set.add(compl);
        }
        
        int field = 0;
        for (int i = 0; i < selected.size(); i++) {
            field |= (1 << selected.get(i));
        }
        fields.add(field);
    }
}