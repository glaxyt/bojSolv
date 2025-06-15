import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];

        int[] setA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] setB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(setA);
        Arrays.sort(setB);

        // 직접 N으로 찾을 경우 최대 250 000 000 000 이라는 무궁 무진한 복잡도를 맛볼 수 있다.
        // 따라서 N log M 으로 처리할 필요가 있다.
        for (int target : setA) {
            int left = 0;
            int right = M - 1;
            boolean flag = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (target == setB[mid]) {
                    flag = true;
                    break;
                } else if (setB[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (!flag) {
                answer.add(target);
            }
        }

        System.out.println(answer.size());
        if (!answer.isEmpty()) {
            for (int i = 0; i < answer.size(); i++) {
                if (i != answer.size() - 1) {
                    System.out.print(answer.get(i) + " ");
                } else {
                    System.out.println(answer.get(i));
                }
            }
        }
    }
}