import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 파일이 서로 구분되는 경우에 어디까지 읽어봐야 읽어야 좋은걸까

        // 구분이 가능한 값이 들어가면 되긴할듯?
        // 집합이 먼저 생각난다. 들어가는 것을 확인할 수 있기 때문.
        // 근데 집합은 배열이 되는가?
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> files = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            files.add(list);
        }

        int maxK = 0;
        for (int i = 0; i < files.size(); i++) {
            maxK = Math.max(maxK, files.get(i).size());
        }

        for (int k = 1; k <= maxK; k++) {
            Set<List<Integer>> set = new HashSet<>();
            boolean isIdentified = true;

            for (int i = 0; i < n; i++) {
                List<Integer> file = files.get(i);
                List<Integer> prefix = new ArrayList<>();

                for (int j = 0; j < k; j++) {
                    if (j < file.size()) {
                        prefix.add(file.get(j));
                    } else {
                        prefix.add(0);
                    }
                }

                if (set.contains(prefix)) {
                    isIdentified = false;
                    break;
                }
                set.add(prefix);
            }

            if (isIdentified) {
                System.out.println(k);
                return;
            }
        }

        System.out.println(maxK);
    }
}