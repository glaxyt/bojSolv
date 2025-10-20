import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<Integer> answer = new HashSet<>();
    static Set<String> verifyDuplicate = new HashSet<>();
    static int[] limit;
    static int[] bottles = new int[3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        limit = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bottles[2] = limit[2];
        dfs();

        List<Integer> list = new ArrayList<>();
        for (int num : answer) {
            list.add(num);
        }

        list.sort((a, b) -> Integer.compare(a, b));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static void dfs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bottles.length; i++) {
            sb.append(bottles[i]);
        }
        String s = sb.toString();

        if (verifyDuplicate.contains(s)) return;
        verifyDuplicate.add(s);

        if (bottles[0] == 0) {
            answer.add(bottles[2]);
        }

        for (int i = 0; i < bottles.length; i++) {
            if (bottles[i] == 0) continue;
            for (int j = 0; j < bottles.length; j++) {
                if (i == j) continue;
                if (limit[j] == bottles[j]) continue;
                int toss = Math.min(bottles[i], limit[j] - bottles[j]);
                bottles[i] -= toss;
                bottles[j] += toss;
                dfs();
                bottles[j] -= toss;
                bottles[i] += toss;
            }
        }
    }
}