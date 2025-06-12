import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static List<String> answer = new ArrayList<>();
    static Integer[] result;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] parts = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = parts[0];
        M = parts[1];
        result = new Integer[M];

        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(nums);

        backtrack(0);

        bw.flush();
    }

    private static void backtrack(int cnt) throws Exception {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            result[cnt] = nums[i];
            backtrack(cnt + 1);
        }
    }
}
