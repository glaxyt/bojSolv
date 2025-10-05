import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int midCnt = 0;
            PriorityQueue<Integer> leftPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            PriorityQueue<Integer> rightPq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
            List<Integer> nums = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            int numsLength = n / 10;
            if (n % 10 != 0) numsLength++;

            for (int k = 0; k < numsLength; k++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int l = 0; l < line.length; l++) {
                    nums.add(line[l]);
                }
            }

            for (int i = 0; i < nums.size(); i++) {
                int num = nums.get(i);

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

                if (i % 2 == 0) {
                    int newMid = leftPq.peek();
                    sb.append(newMid).append(" ");
                    midCnt++;
                    if (midCnt % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }

            System.out.println(midCnt);
            System.out.println(sb.toString());
        }
    }
}
