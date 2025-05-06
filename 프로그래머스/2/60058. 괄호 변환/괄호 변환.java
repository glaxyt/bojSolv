import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        // '('의 개수와 ')'의 개수가 일치한다면: 균형잡힌 괄호 문자열
        // '()' 올바른 괄호 '열기'와 '닫기'가 되는 문자열이면: 올바른 괄호 문자열 & 균형잡힌 괄호 문자여

        
        // 올바른 괄호 문자열로 나눌 수 있다면..
        
        if (isCorrectStr(p)) return p;
        answer = parseToBalancedStr(p);
        
        return answer;
    }
    
    private String parseToBalancedStr(String p) {
        if (p.isEmpty()) {
            return p;
        }
        
        String u = "";
        
        int openGwalho = 0;
        int closeGwalho = 0;
        
        // 균형잡힌 괄호 문자열로 더는 나눌 수 없는 경우 -> 
        //  ')(' 이 경우 
        // 아 재귀라고 써있네..
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                u = u + "(";
                openGwalho++;
            } else {
                u = u + ")";
                closeGwalho++;
            }
            
            // 균형잡힌 문자열인 u인지 확인
            if (openGwalho == closeGwalho) {
                // 올바른 문자열인 u인지 확인
                if (isCorrectStr(u)) {
                    // u가 올바른 문자열이라면 v에 대해서 1단계부터 다시 수행
                    u += parseToBalancedStr(p.substring(i + 1));
                    System.out.println("correct" + u);
                    return u;
                    
                } else {
                    // u가 올바른 문자열이 아니라면 
                    String v = "(" + parseToBalancedStr(p.substring(i + 1)) + ")";
                    System.out.println("uncorrect v" + v);
                    String reversed = reverseStr(u);
                    System.out.println("uncorrect u " + u);
                    System.out.println("uncorrect reversed " + reversed);


                    return v + reversed;
                }
            }
        }
        
        return u;
    }
    
    public String reverseStr(String u) {
        if (u.isEmpty()) {
            return "";
        }
        
        if (u.length() == 2) {
            return "";
        }
        
        u = u.substring(1, u.length() - 1);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') sb.append(")");
            else sb.append("(");
        }
        
        return sb.toString();
    }
    
    // 올바른 문자열인지 확인하는 메서드
    public boolean isCorrectStr(String u) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if (c == ')') {
                if (st.isEmpty()) return false;
                st.pop();
            } else {
                st.push(c);
            }
        }
        
        if (st.isEmpty()) {
            return true;
        }
        
        return false;
    }
}