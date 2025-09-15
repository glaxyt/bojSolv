import java.util.*;
// 14:34분 시작.
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        // 2개의 큐의 각 원소의 합이 같아야한다.
        // 큐의 동작방식 안에서 최소 횟수는 몇인가?
        // pop해서 insert는 한 작업으로 친다.
        // 배열 앞에 있을수록 먼저 넣은 수이다.
        // 백트래킹 먼저 생각남. 그리디하게 문제를 풀 수는 없다.
        // 길이의 개수는 300000이다. 성능상 문제가 발생할 수 있는가? 
        
        // 한 큐에서 꺼내고 다른 큐에 삽입.
        // 한큐를 중심으로 동작하는걸지도. 사실상 원형으로 된 큐이다. 근데 그것이 구분된..
        // 한 큐의 크기를 무조건적으로 150000을 만들면 해결되긴한다.
        // 만일 작다면 다른 큐로부터 받아와.
        // 만일 크다면 다시 내뱉으면 된다.
        // 
        long que1TotalSum = 0;
        Deque<Integer> que1 = new ArrayDeque<>();
        for (int idx = 0; idx < queue1.length; idx++) {
            int e = queue1[idx];
            que1.offer(e);
            que1TotalSum += e;
        }
        
        long que2TotalSum = 0;
        Deque<Integer> que2 = new ArrayDeque<>();
        for (int idx = 0; idx < queue2.length; idx++) {
            int e = queue2[idx];
            que2.offer(e);
            que2TotalSum += e;
        }
        
        long half = (que1TotalSum + que2TotalSum) / 2;
        
        // 아 구간합도 되겠네.
        // 윈도우로 근데 이거 시간복잡고 모르겠네.
        
        while (half != que1TotalSum) {
            if (answer > 600_000) {
                answer = -1;
                break;
            }
            
            
            if (que1TotalSum > half) {
                if (que1.isEmpty()) {
                    answer = -1;
                    break;
                }
                
                int num = que1.poll();
                que2.offer(num);
                que1TotalSum -= num;
                
            } else {
                if (que2.isEmpty()) {
                    answer = -1;
                    break;
                }
                
                int num = que2.poll();
                que1.offer(num);
                que1TotalSum += num;
            }
            answer++;
        }
        
        return answer;
    }
}