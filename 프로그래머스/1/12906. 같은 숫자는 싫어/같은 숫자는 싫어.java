import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty()) {
                int top = stack.peek();
                if (top == arr[i]) {
                    continue;
                }
            }
            stack.add(arr[i]);
        }

        int[] answer = new int[stack.size()];
        int idx = stack.size() - 1;
        while (!stack.isEmpty()) {
            int c = stack.pop();
            answer[idx--] = c;
        }
        return answer;
    }
}