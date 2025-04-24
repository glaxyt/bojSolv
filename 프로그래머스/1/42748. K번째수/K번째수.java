import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int k = command[2] - 1;
            
            int[] sliced = Arrays.copyOfRange(array, start, end);
            Arrays.sort(sliced);
            answer[idx++] = sliced[k];
        }
        
        return answer;
    }
}