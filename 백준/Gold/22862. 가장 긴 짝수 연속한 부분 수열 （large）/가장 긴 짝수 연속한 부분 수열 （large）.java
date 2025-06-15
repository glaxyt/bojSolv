import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int answer = 0;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = input[0];
        M = input[1];

        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int right = 0;
        int left = 0;
        int odd_cnt = 0;

        while (left < N && right < N) {

            if (nums[right] % 2 != 0) odd_cnt++;

            while (odd_cnt > M & left < N) {
                if (nums[left] % 2 != 0) odd_cnt--;
                left++;
            }

            answer = Math.max(answer, right - left + 1 - odd_cnt);

            right++;
        }

        System.out.println(answer);
    }
}