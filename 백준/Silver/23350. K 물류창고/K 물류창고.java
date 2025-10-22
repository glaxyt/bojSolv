import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 컨테이너를 적재할 때 비용 발생

        // 우선순위가 높을수록 낮은 순서를 가지고 있다. 우선순위가 낮은순서로 적재해야한다.
        // 우선순위가 올바른 순서로 오지않을 경우, 레일 끝으로 다시 보내며, 이때 컨테이너 무게만큼 비용이 발생한다.

        // 컨테이너의 우선순위가 같을 경우, 무게가 무거운 컨테이너를 아래에 배치해야한다.
        // 우선순위를 기준으로 적재를하지만, 이때 무게가 더 무거운 컨테이너가 등장한다면, 재배치가 필요하다.
        // 이때 빼는 컨테이너와 적재하는 컨테이너만큼 비용 발생
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Deque<Container> rail = new ArrayDeque<>();
        Deque<Container> loadArea = new ArrayDeque<>();
        Deque<Container> leftSpace = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int id = data[0];
            int w = data[1];
            pq.offer(id);
            rail.offer(new Container(id, w));
        }

        while (!rail.isEmpty() && !pq.isEmpty()) {
            int fastestId = pq.poll();

            Container cur = rail.pollFirst();
            while (cur.id != fastestId) {
                answer += cur.w;
                rail.offer(cur);
                cur = rail.pollFirst();
            }

            if (loadArea.isEmpty()) {
                loadArea.offer(cur);
                answer += cur.w;
            } else {
                Container topContainer = loadArea.peekLast();

                while (topContainer.id == cur.id && topContainer.w < cur.w) {
                    topContainer = loadArea.pollLast();
                    leftSpace.offer(topContainer);
                    answer += topContainer.w;
                    if (loadArea.isEmpty()) {
                        break;
                    }
                    topContainer = loadArea.peekLast();
                }

                loadArea.offer(cur);
                answer += cur.w;


                while (!leftSpace.isEmpty()) {
                    Container c = leftSpace.pollLast();
                    loadArea.offer(c);
                    answer += c.w;
                }
            }
        }

        System.out.println(answer);

    }
}

class Container {
    int id;
    int w;

    public Container(int id, int w) {
        this.id = id;
        this.w = w;
    }
}
