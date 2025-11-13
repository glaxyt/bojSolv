import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        List<Subject> subjects = new ArrayList<>();
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int i = 0; i < m; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int power = info[0];
            int time = info[1];
            subjects.add(new Subject(power, time));
        }

        dp[0] = 0;

        int answer = 0;
        for (Subject s : subjects) {
            for (int t = n; t >= s.time; t--) {
                if (dp[t-s.time] != Integer.MIN_VALUE) {
                    dp[t] = Math.max(dp[t], dp[t-s.time] + s.power);
                }
            }
        }

        for (int t = 0; t <= n; t++) {
            answer = Math.max(answer, dp[t]);
        }
        System.out.println(answer);    }
}

class Subject {
    int power;
    int time;

    public Subject(int power, int time) {
        this.power = power;
        this.time = time;
    }

}