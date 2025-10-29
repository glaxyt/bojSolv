import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, List<String>> antHome = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 어디서 왔는지를 키로 저장하면될 것 같다.
        List<String> roots = new ArrayList<>();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            String key = "";
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    key = key.concat(input[i]);
                    if (roots.contains(input[i])) continue;
                    roots.add(input[i]);
                    antHome.put(input[i], new ArrayList<>());
                    continue;
                }

                List<String> underFloor = antHome.getOrDefault(key, new ArrayList<>());
                if (!underFloor.contains(input[i])) {
                    underFloor.add(input[i]);
                }
                antHome.put(key, underFloor);

                key = key.concat("-" + input[i]);
            }
        }
        roots.sort(Comparator.naturalOrder());
        for (String k : roots) {
            System.out.println(k);
            dfs("", k, 1);
        }
    }


    private static void dfs(String trace, String k, int depth) {
        if (!antHome.containsKey(trace + k)) return;

        List<String> foods = antHome.get(trace + k);
        foods.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }

        String floorExp = sb.toString();

        for (String f : foods) {
            System.out.println(floorExp+f);
            dfs(trace + k + "-", f, depth+1);
        }
    }
}
