import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] prime;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        backtracking(2, 1);
        backtracking(3, 1);
        backtracking(5, 1);
        backtracking(7, 1);

        for (Integer i : answer) {
            System.out.println(i);
        }
    }

    private static void backtracking(int cur_num, int cnt) {
        if (cnt == N) {
            answer.add(cur_num);
            return;
        }

        for (int i = 1; i < 10; i += 2) {
            int next_num = (cur_num * 10) + i;
            if (isPrime(next_num)) backtracking(next_num, cnt + 1);
        }
    }


    private static boolean isPrime(Integer n) {
        if (n < 2) return false;
        if (n == 2) return true;

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
