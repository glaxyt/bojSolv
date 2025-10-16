import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int GRID_LEN = 4;
    static int answer = Integer.MIN_VALUE;
    // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    static final int[][] DXYS = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static boolean[] alreadyEat = new boolean[GRID_LEN * GRID_LEN + 1];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // low > high인경우 인쇄 X
        // 겹치는 페이지는 하나만 인쇄,
        // 범위 안에서만 인쇄

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            boolean[] print = new boolean[n+1];

            String[] pages = br.readLine().split(",");
            for (String page : pages) {
                if (page.contains("-")) {
                    String[] pair = page.split("-");
                    int lower = Integer.parseInt(pair[0]);
                    int higher = Integer.parseInt(pair[1]);
                    if (lower > higher) continue;
                    if (higher > n) higher = n;
                    for (int i = lower; i <= higher; i++) {
                        print[i] = true;
                    }

                } else {
                    int p = Integer.parseInt(page);
                    if (p > n || p < 0) continue;
                    print[p] = true;
                }
            }

            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (print[i]) answer++;
            }

            System.out.println(answer);
        }
    }
}