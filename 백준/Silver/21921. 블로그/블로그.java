import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int x = input[1];

        int[] visitedCounts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        int totalCnt = 0;
        int maxCnt = 1;

        for (int i = 0; i < x; i++) {
            totalCnt += visitedCounts[i];
        }
        answer = Math.max(answer, totalCnt);

        for (int i = x; i < n; i++) {
            totalCnt -= visitedCounts[i-x];
            totalCnt += visitedCounts[i];
            if (totalCnt == answer) {
                maxCnt++;
            } else if (totalCnt > answer) {
                answer = totalCnt;
                maxCnt = 1;
            }
        }

        if (totalCnt == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(answer);
            System.out.println(maxCnt);
        }
    }
}