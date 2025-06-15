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

        Set<Integer> map = new HashSet<>();

        while (right < N) {

            while (map.contains(nums[right])) {
                map.remove(nums[left++]);
            }

            map.add(nums[right++]);
            answer += (right - left);
        }

        System.out.println(answer);
    }
}