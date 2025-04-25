import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] supoja1 = {1, 2, 3, 4, 5};
        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = {0, 0, 0};
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if (supoja1[i % supoja1.length] == answers[i]) {
                count[0] += 1;
            }
            if (supoja2[i % supoja2.length] == answers[i]) {
                count[1] += 1;
            }
            if (supoja3[i % supoja3.length] == answers[i]) {
                count[2] += 1;
            }
        }
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        for (int idx = 0; idx < 3; idx++) {
            if (count[idx] == max) list.add(idx+1);
        }
        System.out.println("answer: " + Arrays.toString(count));
        return list.stream().mapToInt(i -> i).toArray();
    }
}