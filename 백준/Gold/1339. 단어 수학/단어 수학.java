import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, Long> weight = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
            int len = s.length();
            for (int j = 0; j < len; j++) {
                char c = s.charAt(j);
                int pos = len - 1 - j;
                long add = pow10(pos);
                weight.put(c, weight.getOrDefault(c, 0L) + add);
            }
        }


        List<Map.Entry<Character, Long>> list = new ArrayList<>(weight.entrySet());
        list.sort((a, b) -> Long.compare(b.getValue(), a.getValue()));

        int digit = 9;
        Map<Character, Integer> assign = new HashMap<>();
        for (Map.Entry<Character, Long> e : list) {
            assign.put(e.getKey(), digit--);
        }

        long answer = 0L;

        for (Map.Entry<Character, Long> e : list) {
            answer += e.getValue() * assign.get(e.getKey());
        }

        System.out.println(answer);
    }

    static long pow10(int e) {
        long x = 1L;
        while (e-- > 0) x *= 10L;
        return x;
    }
}