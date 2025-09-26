import java.util.*;

class Solution {
    static Map<String, Integer> allToNumber;
    
    static {
        allToNumber = new HashMap<>();
        allToNumber.put("zero", 0); allToNumber.put("one", 1); allToNumber.put("two", 2);
        allToNumber.put("three", 3); allToNumber.put("four", 4); allToNumber.put("five", 5);
        allToNumber.put("six", 6); allToNumber.put("seven", 7); allToNumber.put("eight", 8);
        allToNumber.put("nine", 9); allToNumber.put("0", 0); allToNumber.put("1", 1);
        allToNumber.put("2", 2); allToNumber.put("3", 3); allToNumber.put("4", 4);
        allToNumber.put("5", 5); allToNumber.put("6", 6); allToNumber.put("7", 7);
        allToNumber.put("8", 8); allToNumber.put("9", 9);
    }
    
    public int solution(String s) {
        String answer = "";
        
        String temp = "";
        int idx = 0;
        while (idx < s.length()) {
            temp += s.charAt(idx);

            if (allToNumber.containsKey(temp)) {
                answer += allToNumber.get(temp);
                temp = "";
            }
            idx++;
        }
        
        // 종결 처리도 필요
        return Integer.parseInt(answer);
    }
}
