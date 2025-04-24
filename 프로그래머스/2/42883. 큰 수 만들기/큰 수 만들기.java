import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] numArr = number.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (char c : numArr) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        if (k > 0) {
            k--;
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}