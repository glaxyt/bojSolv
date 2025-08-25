import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if (pq.size() < n) {
                    pq.add(line[j]);
                } else {
                    if (pq.peek() < line[j]) {
                        pq.poll();
                        pq.offer(line[j]);
                    }
                }
            }
        }
        System.out.println(pq.peek());
    }
}
