import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // 7가지의 선택이 주어져있다.
        // 어떤 것이 동의고 비동의인지 잘 모르겠다.
        // 그렇다면 앞에 먼저 나온게 동의고 나머지가 비동의인 듯.
        // 
        Map<Character, Integer> personality = new HashMap<>();
        
        Map<Integer, Integer> score = Map.of(
            1, 3,
            2, 2,
            3, 1,
            5, 1,
            6, 2,
            7, 3
        );
        
        for (int idx = 0; idx < survey.length; idx++) {
            String question = survey[idx];
            
            char agreePersonality = question.charAt(0);
            char nonAgreePersonality = question.charAt(1);
            
            int choice = choices[idx];
            
            if (choice == 4) continue;
            
            if (choice > 4) {
                personality.put(nonAgreePersonality, 
                                personality.getOrDefault(nonAgreePersonality, 0) + score.get(choice));
            } else {
                personality.put(agreePersonality, 
                                personality.getOrDefault(agreePersonality, 0) + score.get(choice));
            }
        }
                
        answer = printPersonality(personality);
        
        return answer;
    }
    
    private static String printPersonality(Map<Character, Integer> personality) {
        StringBuilder sb = new StringBuilder();
        int rScore = personality.getOrDefault('R', 0);
        int tScore = personality.getOrDefault('T', 0);
        int cScore = personality.getOrDefault('C', 0);
        int fScore = personality.getOrDefault('F', 0);
        int jScore = personality.getOrDefault('J', 0);
        int mScore = personality.getOrDefault('M', 0);
        int aScore = personality.getOrDefault('A', 0);
        int nScore = personality.getOrDefault('N', 0);
        
        if (rScore >= tScore) sb.append('R');
        else sb.append('T');
        
        if (cScore >= fScore) sb.append('C');
        else sb.append('F');
        
        if (jScore >= mScore) sb.append('J');
        else sb.append('M');
        
        if (aScore >= nScore) sb.append('A');
        else sb.append('N');
        
        return sb.toString();
    }
}