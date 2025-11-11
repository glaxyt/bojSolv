import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static List<List<Discount>> discount = new ArrayList<>();
    static boolean[] visited;
    static int[] potion;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        potion = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            discount.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int p = Integer.parseInt(br.readLine());
            for (int j = 0; j < p; j++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int a = input[0];
                int d = input[1];
                discount.get(i).add(new Discount(a, d));
            }
        }

        dfs(n, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int n, int cnt, int result) {
        if (cnt == n) {
            answer = Math.min(answer, result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cost = potion[i];
                if (cost < 1) cost = 1;

                for (Discount d : discount.get(i+1)) {
                    potion[d.id-1] -= d.discount;
                }
                visited[i] = true;

                dfs(n, cnt+1, result + cost);

                visited[i] = false;
                for (Discount d : discount.get(i+1)) {
                    potion[d.id-1] += d.discount;
                }
            }
        }
    }
}

class Discount {
    int id;
    int discount;

    public Discount(int id, int discount) {
        this.id = id;
        this.discount = discount;
    }
}