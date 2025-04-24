import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        // 진출 지점을 기준으로 오름차순
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        // 최소한의 카메라로 설치하는 방법은 진출 시점에 설치하는 것이다.
        int camera = -30001;
        answer = 0;
        for (int[] route : routes) {
            int start = route[0], end = route[1];
            if (camera < start) {
                camera = end;
                answer += 1;
            }
        }
        
        return answer;
    }
}