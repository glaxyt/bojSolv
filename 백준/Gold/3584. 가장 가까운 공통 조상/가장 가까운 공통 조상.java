import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            List<Node> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new Node(i, null));
            }

            for (int i = 0; i < n-1; i++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int a = input[0];
                int b = input[1];

                graph.get(b).parent = graph.get(a);
            }

            int[] targets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Node t1 = graph.get(targets[0]);
            Set<Integer> parents = new HashSet<>();
            parents.add(t1.id);
            while (t1.parent != null) {
                parents.add(t1.parent.id);
                t1 = t1.parent;
            }

            Node t2 = graph.get(targets[1]);
            if (parents.contains(t2.id)) {
                System.out.println(t2.id);
            } else {
                while (t2.parent != null) {
                    if (parents.contains(t2.parent.id)) {
                        System.out.println(t2.parent.id);
                        break;
                    }
                    t2 = t2.parent;
                }
            }
        }
    }

}

class Node {
    int id;
    Node parent;

    public Node(int id, Node parent) {
        this.id = id;
        this.parent = parent;
    }
}