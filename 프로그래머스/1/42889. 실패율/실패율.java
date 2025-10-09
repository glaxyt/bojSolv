import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        PriorityQueue<Stage> pq = new PriorityQueue<>((a, b) -> {
            int compare = Double.compare(b.failRate, a.failRate);
            if (compare != 0) return compare;
            return a.id - b.id;
        });
        
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        for (int stage = 1; stage <= N; stage++) {
            int fail = 0;
            int cnt = 0;
            for (int i = 0; i < stages.length; i++) {
                if (stage <= stages[i]) {
                    cnt++;
                    if (stage == stages[i]) {
                        fail++;
                    }
                }
            }
            pq.offer(new Stage(stage, cnt == 0 ? 0 : (double) fail / cnt));        
        }
        
        int idx = 0;
        while (!pq.isEmpty()) {
            Stage st = pq.poll();
            answer[idx] = st.id;
            idx++;
        }
    
        return answer;
    }
}

class Stage {
    int id;
    double failRate;
    
    public Stage(int id, double failRate) {
        this.id = id;
        this.failRate = failRate;
    }
}