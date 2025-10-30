import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int answer = 0;
    static boolean[] col;
    static boolean[] rightDiag;
    static boolean[] leftDiag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 모든 행마다 하나의 퀸이 존재해야한다
        // 현재 행의 개수는 dfs 매개변수로 관리.
        // 열 관리는 따로 관리 필요.
        // 그리고 퀸은 대각선을 제어한다.

        n = Integer.parseInt(br.readLine());
        col = new boolean[n];
        rightDiag = new boolean[2*n-1];
        leftDiag = new boolean[2*n-1];

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int x) {
        if (x == n) {
            answer++;
            return;
        }

        for (int y = 0; y < n; y++) {
            int leftDiagIdx = x - y + (n - 1);
            int rightDiagIdx = x + y;

            if (!col[y] && !leftDiag[leftDiagIdx] && !rightDiag[rightDiagIdx]) {
                col[y] = true;
                leftDiag[leftDiagIdx] = true;
                rightDiag[rightDiagIdx] = true;

                dfs(x + 1);

                col[y] = false;
                leftDiag[leftDiagIdx] = false;
                rightDiag[rightDiagIdx] = false;
            }
        }
    }
}