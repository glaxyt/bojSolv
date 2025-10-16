import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] seq;
    static boolean flag = false;
    static final int[][] DXYS = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열을 입력받고 1, 2, 3 중에서 고른다. 그 이후에 계산을 추가로한다.

        int n = Integer.parseInt(br.readLine());
        seq = initialSeq(n);

        dfs(n, 0);
    }

    private static void dfs(int n, int cnt) {
        if (flag) return;

        if (cnt == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(seq[i]);
            }
            flag = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            seq[cnt] = i;
            if (hasPartSeq(cnt)) continue;
            dfs(n, cnt+1);
            if (flag) return;
        }
    }

    private static int[] initialSeq(int n) {
        return new int[n];
    }

    private static boolean hasPartSeq(int cnt) {
        if (cnt == 0) return false;

        for (int k = 1; k <= (cnt+1) / 2; k++) {
            boolean flag = true;
            for (int i = 0; i < k; i++) {
                if (seq[cnt - i] != seq[cnt - i - k]) {
                    flag = false;
                    break;
                }
             }

             if (flag) return true;
        }

        return false;
    }

}