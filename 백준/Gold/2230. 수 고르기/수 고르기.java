import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = input[0];
        int M = input[1];

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }

        nums.sort(Comparator.naturalOrder());

        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;

        while (left < N && right < N) {
            int diff = nums.get(right) - nums.get(left);

            if (diff >= M) {
                answer = Math.min(answer, diff);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(answer);
    }
}