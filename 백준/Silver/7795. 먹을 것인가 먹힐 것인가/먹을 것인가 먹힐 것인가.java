import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Integer[] predators = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer[] feed = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            Arrays.sort(predators, Collections.reverseOrder());
            Arrays.sort(feed);

            int result = 0;
            for (int predator : predators) {
                for (Integer integer : feed) {
                    if (predator > integer) {
                        result++;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
