import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 시간복잡도면에서 그렇게 불리해보이지는 않는다.
        // 우선 가장 빠른 날짜부터 잡는게 맞을듯?
        // 백트래킹이 맞는가? 안어룰리는 근거는?
        // 점수가 최댓값이어야하니 이 값들을 우선적으로 정렬해서 우겨넣어봐야한다.
        List<int[]> assignments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] assignmentData = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            assignments.add(assignmentData);
        }

        assignments.sort(Comparator.comparing((int[] data) -> (data[1])).reversed());

        int answer = 0;
        boolean[] visited = new boolean[1001];

        for (int i = 0; i < n; i++) {
            int d = assignments.get(i)[0];
            int w = assignments.get(i)[1];

            int idx = d;
            while(idx > 0) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    answer += w;
                    break;
                }
                idx--;
            }
        }
        System.out.println(answer);
    }
}