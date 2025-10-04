import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        boolean[] deleted = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        for (String command : cmd) {
            String[] commands = command.split(" ");
            String order = commands[0];
            
            if (order.equals("U")) {
                int num = Integer.parseInt(commands[1]);
                for (int i = 0; i < num; i++) {
                    k = prev[k];
                }
            } else if (order.equals("D")) {
                int num = Integer.parseInt(commands[1]);
                for (int i = 0; i < num; i++) {
                    k = next[k];
                }
            } else if (order.equals("C")) {
                deleted[k] = true;
                stack.push(k);
                int prevIdx = prev[k];
                int nextIdx = next[k];
                
                if (prevIdx != -1) {
                    next[prevIdx] = nextIdx;
                }
                if (nextIdx != n) {
                    prev[nextIdx] = prevIdx;
                }
                
                k = (nextIdx < n) ? nextIdx : prevIdx;
            } else {
                int restore = stack.pop();
                deleted[restore] = false;
                
                int prevIdx = prev[restore];
                int nextIdx = next[restore];
                
                if (prevIdx != -1) {
                    next[prevIdx] = restore;
                }
                if (nextIdx != n) {
                    prev[nextIdx] = restore;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (deleted[i]) sb.append("X");
            else sb.append("O");
        }
        
        return sb.toString();
    }
}