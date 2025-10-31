import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 백트래킹은 불가하다ㅏ. 5000C3이라서.
        // -97 -6 -2 6 98
        // 양끝을 더한다. -1인데, 여기서 내가 이거에 가까운 친구를 구한다가 목표.

        // -97과 98의 사이를 구한다.
        // mid = -2이다. 내가 원하는 타겟값인 -1보다 작다 그러면 mid에서 더 올려본다.
        // 6이 미드가된다. 안된다 이건 오히려 최종값이 크다. 결국 -2선정.
        // 다음 입력도 가야한다.
        // 어떻게 다음 입력을 가는가?

        int n = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long[] answer = new long[3];

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                long sum = arr[i] + arr[l] + arr[r];
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[l];
                    answer[2] = arr[r];
                }
                if (sum > 0) r--;
                else l++;
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}