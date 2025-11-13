import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = input[0];
            int m = input[1];
            int p = input[2];
            List<List<Integer>> graph = new ArrayList<>();
            int[] indegree = new int[m + 1];
            Strahler[] maxStrahler = new Strahler[m + 1];
            for (int i = 1; i <= m; i++) {
                maxStrahler[i] = new Strahler(0, 0);
            }

            int[] answer = new int[m + 1];
            for (int i = 0; i <= m; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < p; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int a = line[0];
                int b = line[1];

                graph.get(a).add(b);
                indegree[b]++;
            }

            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 1; i <= m; i++) {
                if (indegree[i] == 0) {
                    dq.offer(i);
                    answer[i] = 1;
                }
            }

            while (!dq.isEmpty()) {
                Integer cur = dq.poll();

                for (Integer nx : graph.get(cur)) {
                    indegree[nx]--;
                    maxStrahler[nx].add(answer[cur]);

                    if (indegree[nx] == 0) {
                        dq.offer(nx);
                        answer[nx] = maxStrahler[nx].getMaxOrder();
                    }
                }
            }

            System.out.println(k + " " + answer[m]);
        }
    }
}

class Strahler {
    int order;
    int cnt;

    public Strahler(int order, int cnt) {
        this.order = order;
        this.cnt = cnt;
    }

    public void add(int cur) {
        if (cur == order) {
            cnt++;
        } else if (cur > order) {
            order = cur;
            cnt = 1;
        }
    }

    public int getMaxOrder() {
        if (cnt > 1) return order + 1;
        return order;
    }
}


