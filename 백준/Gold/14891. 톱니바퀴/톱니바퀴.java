import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]> wheels = new ArrayList<>();
    static int[] wheelTopIdx = new int[5];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheels.add(new int[0]);
        for (int i = 0; i < 4; i++) {
            int[] wheel = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            wheels.add(wheel);
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int wheelIdx = input[0];
            int rotateDir = input[1];

            rotateWheel(wheelIdx, rotateDir);
        }

        solve();
        System.out.println(answer);
}

    private static void rotateWheel(int wheelIdx, int rotateDir) {
        int[] flag = new int[5];
        flag[wheelIdx] = rotateDir;

        // 어떤 방향으로 나아가야하는지 주의 필요
        for (int i = wheelIdx; i < 4; i++) {
            int firstWheelTopIdx = wheelTopIdx[i];
            int secondWheelTopIdx = wheelTopIdx[i + 1];
            if (wheels.get(i)[(firstWheelTopIdx + 2) % 8] != wheels.get(i + 1)[(secondWheelTopIdx + 6) % 8]) {
                flag[i + 1] = -flag[i];
            } else {
                break;
            }
        }

        for (int i = wheelIdx; i > 1; i--) {
            int firstWheelTopIdx = wheelTopIdx[i];
            int secondWheelTopIdx = wheelTopIdx[i - 1];
            if (wheels.get(i)[(firstWheelTopIdx + 6) % 8] != wheels.get(i - 1)[(secondWheelTopIdx + 2) % 8]) {
                flag[i - 1] = -flag[i];
            } else {
                break;
            }
        }

        // 회전해야하는 톱니바퀴는 정해진 방향에 따라 회전시킨다.
        for (int i = 1; i < 5; i++) {
            if (flag[i] == 1) {
                wheelTopIdx[i] = (wheelTopIdx[i] + 7) % 8;
            } else if (flag[i] == -1){
                wheelTopIdx[i] = (wheelTopIdx[i] + 1) % 8;
            }
        }
    }

    private static void solve() {
        if (wheels.get(1)[wheelTopIdx[1]] == 1) answer += 1;
        if (wheels.get(2)[wheelTopIdx[2]] == 1) answer += 2;
        if (wheels.get(3)[wheelTopIdx[3]] == 1) answer += 4;
        if (wheels.get(4)[wheelTopIdx[4]] == 1) answer += 8;
    }
}
