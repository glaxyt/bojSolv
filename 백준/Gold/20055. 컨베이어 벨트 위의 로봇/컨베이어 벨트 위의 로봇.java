import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int answer = 0;

        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n: 위쪽 벨트 길이, k: 종료 조건
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 벨트의 내구도 배열 (2n 길이)
        int[] belt = new int[2 * n];
        boolean[] robot = new boolean[2 * n]; // 각 위치에 로봇이 있는지 여부

        // 두 번째 줄: 내구도 정보
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int belt_len = belt.length;

        while (true) {
            answer++;

            // 컨베이어 벨트 회전
            start = (start - 1 + 2 * n) % belt_len;
            int end = (start + n - 1) % belt_len;
            robot[end] = false;

            // 로봇 이동
            for (int i = n - 2; i > -1; i--) {
                int cur = (start + i) % belt_len;
                int move = (cur + 1) % belt_len;
                if (robot[cur] && !robot[move] && belt[move] > 0) {
                    robot[move] = true;
                    robot[cur] = false;
                    belt[move]--;
                }
            }
            robot[end] = false;

            if (belt[start] > 0 && !robot[start]) {
                robot[start] = true;
                belt[start]--;
            }

            int cnt = 0;
            for (int i = 0; i < belt_len; i++) {
                if (belt[i] == 0) cnt++;
            }

            if (cnt >= k) {
                System.out.println(answer);
                break;
            }
        }
    }
}
