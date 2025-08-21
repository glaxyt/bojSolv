import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int answer = 0;
    static int n;
    static int l;
    static int r;
    static int x;
    static List<Integer> difficulty;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        l = input[1];
        r = input[2];
        x = input[3];
        difficulty = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 정렬의 필요성 중복 없이 돌리기 위해
        difficulty.sort((a, b) -> Integer.compare(a, b));

        findAvailableCourse(0, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(answer);
    }

    private static void findAvailableCourse(int cnt, int idx, int total, int maxDifficulty, int minDifficulty) {
        if (cnt >= 2 && total >= l && maxDifficulty - minDifficulty >= x) {
            if (total <= r) {
                answer++;
            } else {
                return;
            }

        }

        for (int i = idx; i < n; i++) {
            int curDifficulty = difficulty.get(i);
            findAvailableCourse(
                    cnt + 1,
                    i + 1,
                    total + curDifficulty,
                    Math.max(maxDifficulty, curDifficulty),
                    Math.min(minDifficulty, curDifficulty)
            );
        }
    }
}