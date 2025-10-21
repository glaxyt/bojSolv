import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 진실을 아는 사람들이 있는 파티에서는 진실을.
        // 진실을 모르는 사람들만 있따면 거짓말을..
        // 진실을 들은 애들이 있는 파티에서는 거짓말을 얘기할 수 없다.
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        parents = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parents[i] = i;
        }

        int[] knowTrue = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> whoKnowTrue = new HashSet<>();
        for (int i = 1; i < knowTrue[0] + 1; i++) {
            whoKnowTrue.add(knowTrue[i]);
        }
        List<int[]> parties = new ArrayList<>();
        while (m-- > 0) {
            int[] party = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 2; i < party.length; i++) {
                union(party[1], party[i]);
            }
            parties.add(party);
        }

        Set<Integer> truthRoots = new HashSet<>();
        for (int person : whoKnowTrue) {
            truthRoots.add(findParent(person));
        }

        int answer = 0;
        for (int[] party : parties) {
            boolean flag = true;
            for (int i = 1; i < party.length; i++) {
                if (truthRoots.contains(findParent(party[i]))) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);
        if (p1 != p2) {
            parents[p2] = p1;
        }
    }

    private static int findParent(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = findParent(parents[x]);
    }
}
