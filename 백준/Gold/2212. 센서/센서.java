import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] loc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (k >= n) {
            System.out.println(0);
            return;
        }

        Arrays.sort(loc);

        int[] inter = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            inter[i] = loc[i + 1] - loc[i];
        }

        Arrays.sort(inter);

        int answer = 0;
        for (int i = 0; i < n - k; i++) {
            answer += inter[i];
        }

        System.out.println(answer);
    }
}
