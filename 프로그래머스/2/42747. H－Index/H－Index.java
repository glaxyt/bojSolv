import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        // [0, 2, 3, 5, 6]
        // 인용횟수 중복 시

        // for (int h = 0; h < citations.length; h++) {
        //     // 현재 인용횟수로부터 h개 이상인지 확인
        //     if (h == citations[h] - 1) {
        //         return citations[i];
        //     }
        // }
        
        for (int h = 0; h < citations.length; h++) {
            int upperThanCit = citations.length - h;
            // [0, 1, 2, 3, 4]
            if (upperThanCit <= citations[h]) {
                answer = upperThanCit;
                break;
            }
        }

        return answer;
    }
}