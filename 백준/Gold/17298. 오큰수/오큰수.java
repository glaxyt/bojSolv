import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                answer[st.pop()] = nums[i];
            }
            st.add(i);
        }
        for (int ans : answer) {
            sb.append(ans).append(' ');
        }
        System.out.println(sb);
    }
}