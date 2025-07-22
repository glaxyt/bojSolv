import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] w = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        System.out.println(getGroupMinWeight(n, w));
    }

    private static int getGroupMinWeight(int n, int[] w) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, w[i] + w[2*n - 1 - i]);
        }
        return answer;
    }
}
