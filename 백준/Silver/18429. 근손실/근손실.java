import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;
    static int n;
    static int k;
    static int[] weightKits;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        k = input[1];
        weightKits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[n];

        findAvailableCourse(0, 500);
        System.out.println(answer);
    }

    private static void findAvailableCourse(int days, int weight) {
        if (days == n) {
            if (weight >= 500) {
                answer++;
            }
            return;
        }

        if (weight < 500) return;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                findAvailableCourse(days + 1, weight + weightKits[i] - k);
                visited[i] = false;
            }
        }
    }
}