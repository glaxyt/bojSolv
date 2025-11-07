import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] winCnt = new int[3];
    static int[] rndCnt = new int[3];
    static int[][] vs;
    static int[][] bigData = new int[3][20];
    static int n, t;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 손싸움의 경쟁 구도를 확인했다.
        // 누가 어떤 것을 내는지도 인지했으면, 나는 여러개를 내면서 결국에는 우승으로 나아갈 수 있는지 확인하는것.

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        t = input[1];

        vs = new int[n][n];
        visited = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                vs[i][j] = line[j];
            }
        }

        for (int i = 1; i <= 2; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 20; j++) {
                bigData[i][j] = line[j];
            }
        }

        if (dfs(0, 1, 1)) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean dfs(int fst, int sec, int rnd) {
        if (winCnt[1] == t || winCnt[2] == t) return false;

        if (winCnt[0] == t) {
            return true;
        }

        // 누구와 누구랑 싸우게 될 것인가?
        if (fst == 0) {
            int secHand = bigData[sec][rndCnt[sec]++] - 1;
            for (int jw = 1; jw <= n; jw++) {
                if (visited[jw]) continue;
                visited[jw] = true;
                if (vs[jw - 1][secHand] == 2) {
                    winCnt[fst]++;
                    if (dfs(fst, switchPlayer(fst, sec), rnd + 1)) return true;
                    winCnt[fst]--;
                } else if (vs[jw - 1][secHand] == 0) {
                    winCnt[sec]++;
                    if (dfs(sec, switchPlayer(sec, fst), rnd + 1)) return true;
                    winCnt[sec]--;
                }
                visited[jw] = false;
                // else {
                //     winCnt[sec]++;
                //     dfs(sec, switchPlayer(sec, fst), rnd + 1);
                //     winCnt[sec]--;
                // }
            }
            rndCnt[sec]--;
        } else if (sec == 0) {
            int fstHand = bigData[fst][rndCnt[fst]++] - 1;
            for (int jw = 1; jw <= n; jw++) {
                if (visited[jw]) continue;
                visited[jw] = true;
                if (vs[fstHand][jw - 1] == 2) {
                    winCnt[fst]++;
                    if (dfs(fst, switchPlayer(fst, sec), rnd + 1)) return true;
                    winCnt[fst]--;
                } else if (vs[fstHand][jw - 1] == 0) {
                    winCnt[sec]++;
                    if (dfs(sec, switchPlayer(sec, fst), rnd + 1)) return true;
                    winCnt[sec]--;
                }
                visited[jw] = false;
                // else {
                //     winCnt[fst]++;
                //     dfs(fst, switchPlayer(fst, sec), rnd + 1);
                //     winCnt[fst]--;
                // }
            }
            rndCnt[fst]--;
        } else {
            int fstHand = bigData[fst][rndCnt[fst]++] - 1;
            int secHand = bigData[sec][rndCnt[sec]++] - 1;
            if (vs[fstHand][secHand] == 2) {
                winCnt[fst]++;
                if (dfs(fst, switchPlayer(fst, sec), rnd+1)) return true;
                winCnt[fst]--;
            } else if (vs[fstHand][secHand] == 0) {
                winCnt[sec]++;
                if (dfs(sec, switchPlayer(sec, fst), rnd+1)) return true;
                winCnt[sec]--;
            } else {
                int winner = fst;
                int looser = sec;
                if (fst < sec) {
                    winner = sec;
                    looser = fst;
                }
                winCnt[winner]++;
                if (dfs(winner, switchPlayer(winner, looser), rnd + 1)) return true;
                winCnt[winner]--;
            }
            rndCnt[fst]--;
            rndCnt[sec]--;
        }

        return false;
    }

    public static int switchPlayer(int winner, int looser) {
        for (int i = 0; i < 3; i++) {
            if (i != winner && i != looser) {
                return i;
            }
        }

        return 0;
    }
}
