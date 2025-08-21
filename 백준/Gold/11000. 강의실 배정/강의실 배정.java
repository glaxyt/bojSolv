import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> schedules = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            schedules.add(input);
        }

        schedules.sort((a, b) ->Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] schedule : schedules) {
            int start = schedule[0];
            int end = schedule[1];

            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}