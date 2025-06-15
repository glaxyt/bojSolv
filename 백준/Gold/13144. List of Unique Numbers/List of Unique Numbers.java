import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int right = 0;
        long answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (right < N) {

            if (map.containsKey(nums[right])) {
                while (map.containsKey(nums[right])) {
                    map.remove(nums[left++]);
                }
            }
            map.put(nums[right++], 1);
            answer += (right - left);
        }

        System.out.println(answer);
    }
}