import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = input[0];
        int w = input[1];

        int[] grid = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        int left_idx = 0;
        int right_idx = w - 1;

        for (int i = 1; i < w; i++) {
            if (grid[left_idx] <= grid[i]) {
                if (grid[left_idx] == 0) {
                    left_idx = i;
                    continue;
                }

                for (int j = left_idx; j < i; j++) {
                    answer += grid[left_idx] - grid[j];
                }

                left_idx = i;

            } else {
                if (i == w - 1) {
                    for (int j = w - 1; j > left_idx; j--) {
                        if (grid[right_idx] > grid[j]) {
                            answer += grid[right_idx] - grid[j];
                        } else {
                            right_idx = j;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}