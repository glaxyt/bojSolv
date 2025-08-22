import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> woods = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
            woods.sort((a, b) -> Integer.compare(a, b));
            int result = 0;
            for (int idx = 2; idx < n; idx++) {
                result = Math.max(result, Math.abs(woods.get(idx) - woods.get(idx - 2)));
            }
            System.out.println(result);
        }

    }
}
