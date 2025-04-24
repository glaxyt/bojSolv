import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        // System.out.println(Arrays.toString(nums));
        if (nums[0].equals("0")) {
            return "0";
        }
        answer = String.join(answer, nums);
        return answer;
    }
}