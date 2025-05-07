import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1000;
        int maxLen = s.length();
        if (s.length() == 1) return 1;
        
        for (int len = 1; len < maxLen; len++) {
            int cnt = 1;
            int idx = 0;
            String result = "";
            String curWord = s.substring(idx, idx + len);
            idx += len;
            
            while (idx <= maxLen - len) {
                String nextWord = s.substring(idx, idx + len);
                // System.out.println(curWord + " " + nextWord);
                if (curWord.equals(nextWord)) {
                    cnt++;
                } else {
                    // 두자리 수 나오면 어떡할건데
                    // 그냥 더해서 마지막에 length로 뽑자
                    if (cnt > 1) result += (cnt + curWord);
                    else result += curWord;
                    curWord = nextWord;
                    cnt = 1;
                }
                idx += len;
            }
            
            if (cnt > 1) result += (cnt + curWord);
            else result += curWord;
            
            if (idx < maxLen) {
                result += s.substring(idx);
            }
            
            // System.out.println("last     " + result);
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}