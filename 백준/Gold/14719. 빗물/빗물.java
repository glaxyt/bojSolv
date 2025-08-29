import java.io.*;
import java.util.*;
// 10:30 시작
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = input[0];
        int w = input[1];
        // 빗물이 고이는 장소를 탐색하는 것.
        // 스택인가? 그리디로 풀 수 있을듯.
        // 첫 땅의 높이를 저장. 이후 이것보다 높은게 나온다면 새롭게 갱신
        // 첫땅의 높이를 저장. 이후 이것보다 낮은게 나온다면 일단 계산 시작. 첫땅 높이 - 낮은땅
        // 첫땅의 높이를 저장 이후 이것과 같은게 나온다면 새롭게 갱신
        // 낮은땅으로 갱신하다가. -> 높은땅이 나온다 혹은 나랑 같은 땅이 나온다. -> 합산


        int[] lands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int leftLandHeight = lands[0];
        int leftIdx = 0;
        int idx = 1;
        int answer = 0;
        while (idx < w) {
            // 첫 땅의 높이보다 같거나 높을 경우에는 갱신.
            if (idx == w - 1 && leftLandHeight > lands[idx]) {
                int rightLandHeight = lands[idx];
                for (int i = w - 2; i > leftIdx; i--) {
                    if (rightLandHeight < lands[i]) {
                        rightLandHeight = lands[i];
                    } else {
                        answer += rightLandHeight - lands[i];
                    }
                }
                break;
            }
            // 3 0 3 1 2 1
            // 3 2 1 2 1 2
            // 6 5 4 3 2 1

            if (leftLandHeight <= lands[idx]) {
                int standard = Math.min(leftLandHeight, lands[idx]);
                for (int i = leftIdx; i < idx; i++) {
                    answer += standard - lands[i];
                }
                leftLandHeight = lands[idx];
                leftIdx = idx;
            }
            idx++;
        }

        System.out.println(answer);
    }
}