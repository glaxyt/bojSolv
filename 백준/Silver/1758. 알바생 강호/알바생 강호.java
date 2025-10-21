import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> tips = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tips.add(Integer.parseInt(br.readLine()));
        }

        tips.sort((a, b) -> Integer.compare(b, a));

        long answer = 0;
        for (int i = 0; i < n; i++) {
            int tip = (tips.get(i) - i);
            if (tip < 0) continue;
            answer += (tips.get(i) - i);
        }

        System.out.println(answer);
    }
}