import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
        dfs("", 0);
        answer = list.indexOf(word) + 1;
        return answer;
    }
    
    public void dfs(String temp, int depth) {
        if (depth == 6) {
            return;
        }
        
        if (!temp.isEmpty()) {
            list.add(temp);
        }
        
        for (String vowel : vowels) {
            dfs(temp + vowel, depth + 1);
        }
    }
}