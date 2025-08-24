import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int n = input[0];
        int c = input[1];
        Integer[] num = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Map<Integer, int[]> countMap = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int key = num[i];
            if (!countMap.containsKey(key)) {
                int[] value = new int[]{idx, 1};
                countMap.put(key, value);
                idx++;
            } else {
                countMap.get(key)[1]++;
            }
        }

        List<int[]> result = new ArrayList<>();
        for (Integer key : countMap.keySet()) {
            int[] value = countMap.get(key);
            result.add(new int[]{key, value[0], value[1]});
        }

        result.sort((a, b) -> {
            int compare1 = Integer.compare(b[2], a[2]);
            if (compare1 != 0) return compare1;
            return Integer.compare(a[1], b[1]);
        });

        for (int[] value : result) {
            while (value[2]-- > 0) {
                System.out.print(value[0] + " ");
            }
        }
    }
}
