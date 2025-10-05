import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 숫자를 입력받는다.
        // 오른쪽 우선순위 큐에 넣는다.
        // 중앙값은 항상 왼쪽 우선순위큐에 존재한다.
        // 전체개수가 짝수면, 두 우선순위 큐의 수를 추출한다.
        // 그래 가보자.

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> rightPq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (leftPq.isEmpty() || num <= leftPq.peek()) {
                leftPq.offer(num);
            } else {
                rightPq.offer(num);
            }

            if (leftPq.size() > rightPq.size() + 1) {
                rightPq.offer(leftPq.poll());
            } else if (leftPq.size() < rightPq.size()) {
                leftPq.offer(rightPq.poll());
            }

            System.out.println(leftPq.peek());
        }
    }
}
