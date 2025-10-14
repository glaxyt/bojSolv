import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 10시 29분 시작
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최소 회의실의 방을 우선순위큐에 넣는다.
        // 정렬기준은 회의시작 시간 -> 회의 시간이다.
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>((a, b) -> {
            int result1 = Integer.compare(a.start, b.start);
            if (result1 != 0) return result1;
            return Integer.compare(a.w, b.w);
        });

        for (int i = 0; i < n; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.offer(new Meeting(info[0], info[1]-info[0], info[1]));
        }

        int[] meetingRooms = new int[100_001];
        int roomCnt = 0;
        while (!pq.isEmpty()) {
            Meeting cur = pq.poll();

            boolean canMeeting = false;
            for (int i = 0; i < roomCnt; i++) {
                if (cur.start >= meetingRooms[i]) {
                    canMeeting = true;
                    meetingRooms[i] = cur.finish;
                    break;
                }
            }

            if (!canMeeting) {
                meetingRooms[roomCnt++] = cur.finish;
            }
        }

        System.out.println(roomCnt);
    }
}

class Meeting {
    int start;
    int w;
    int finish;

    public Meeting(int start, int w, int finish) {
        this.start = start;
        this.w = w;
        this.finish = finish;
    }
}
