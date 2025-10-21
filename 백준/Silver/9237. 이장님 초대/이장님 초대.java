import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] seeds = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.sort(seeds, (a, b) -> Integer.compare(b, a));

        int maxLeftTime = 0;
        for (int i = 0; i < n; i++) {
            maxLeftTime--;
            maxLeftTime = Math.max(maxLeftTime, seeds[i]);
        }
        System.out.println(maxLeftTime + n + 1);
    }
}