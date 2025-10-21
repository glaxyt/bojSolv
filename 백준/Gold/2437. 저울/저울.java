import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 추를 어떻게 조작해야하는가?
        // 특정 추들로 모든 숫자를 만들 수 있는지 백트래킹으로는 시도하기 어려워보임.
        // 중복된 수를 계산을 안하게해야한다.

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        int prov = 0;
        for (int i = 0; i < n; i++) {
            if (prov + 1 < nums[i]) break;
            prov += nums[i];
        }

        System.out.println(prov+1);
    }
}