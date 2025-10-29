import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer = 0;
    static List<Integer> energy = new ArrayList<>();
    static boolean[] used;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 그리디하게 풀 수 있는가? 순서를 모르니 계산하기 어렵다.
        // 개수가 크지않기 때문에 8!으로 구할 수 있다.
        int n = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int num : input) {
            energy.add(num);
        }
        used = new boolean[n];
        dfs(n, 0);
        System.out.println(answer);
    }

    private static void dfs(int n, int result) {
        if (energy.size() == 2) {
            answer = Math.max(result, answer);
            return;
        }

        for (int i = 1; i < energy.size()-1; i++) {
            int power = energy.get(i-1) * energy.get(i+1);
            int t = energy.get(i);
            energy.remove(i);
            dfs(n, result + power);
            energy.add(i, t);
        }
    }
}
