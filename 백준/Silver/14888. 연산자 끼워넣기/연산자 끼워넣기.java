import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] ops;
    static String[] opsString = {"+", "-", "*", "/"};
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 연산자 개수: [+, -, *, /]
        ops = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // size = 4

        backtrack(0, 0, "");

        System.out.println(Collections.max(answer));
        System.out.println(Collections.min(answer));
    }

    private static void backtrack(int idx, int cnt, String path) {
        if (cnt == N - 1) {
            calculate(path);
            return;
        }

        for (int i = idx; i < 4; i++) {
            if (ops[i] == 0) {
                backtrack(idx + 1, cnt, path);
            } else {
                ops[i]--;
                backtrack(idx, cnt + 1, path + opsString[i]);
                ops[i]++;
            }
        }
    }

    private static void calculate(String path) {
        int result = nums[0];
        for (int i = 0; i < N - 1; i++) {
            int nextNum = nums[i + 1];
            switch (path.charAt(i)) {
                case '+':
                    result += nextNum;
                    break;
                case '-':
                    result -= nextNum;
                    break;
                case '*':
                    result *= nextNum;
                    break;
                case '/':
                    if (result < 0) result = -(-result / nextNum);
                    else result = result / nextNum;
                    break;
            }
        }
        answer.add(result);
    }
}
