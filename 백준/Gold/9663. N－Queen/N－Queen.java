import java.io.*;

public class Main {
    static int n;
    static int answer = 0;
    static boolean[] col;
    static boolean[] rightDiag;
    static boolean[] leftDiag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        col = new boolean[n];
        rightDiag = new boolean[2*n-1];
        leftDiag = new boolean[2*n-1];

        backtrack(0);

        System.out.println(answer);
    }

    private static void backtrack(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int column = 0; column < n; column++) {
            int leftDiagIdx = row - column + (n - 1);
            int rightDiagIdx = row + column;

            // 해당 열과 대각선이 모두 비어있는지 확인
            if (!col[column] && !leftDiag[leftDiagIdx] && !rightDiag[rightDiagIdx]) {
                col[column] = true;
                leftDiag[leftDiagIdx] = true;
                rightDiag[rightDiagIdx] = true;

                backtrack(row + 1);

                col[column] = false;
                leftDiag[leftDiagIdx] = false;
                rightDiag[rightDiagIdx] = false;
            }
        }
    }
}