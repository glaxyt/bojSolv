import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int answer = 0;
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> line = new ArrayList<>();
            for (int i = 1; i < nums.length; i++) {
                int height = nums[i];
                line.add(height);
                for (int j = 0; j < line.size() - 1; j++) {
                    if (height < line.get(j)) {
                        line.remove(line.size() - 1);
                        answer += (line.size() - j);
                        line.add(j, height);
                        break;
                    }
                }
            }
            System.out.println(nums[0] + " " + answer);
        }
    }
}
