import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 다른 모든 사람의 득표수 보다 많은 득표수를 가질 때, 그 사람이 국회의원에 당선된다.
        // 우선순위큐에 넣어서 최대인애의 수를 줄여가면서 다솜이 그보다 높아지면 종료
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i = 1; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            int top = pq.poll();
            if (dasom > top) break;
            top -= 1;
            dasom++;
            answer++;
            pq.offer(top);
        }

        System.out.println(answer);
    }
}
