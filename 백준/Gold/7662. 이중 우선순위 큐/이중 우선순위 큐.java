import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                String[] cmds = br.readLine().split(" ");
                String cmd = cmds[0];
                int num = Integer.parseInt(cmds[1]);

                if (cmd.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else if (!treeMap.isEmpty() && cmd.equals("D")) {
                    if (num == -1) {
                        int key = treeMap.firstKey();
                        int cnt = treeMap.get(key);
                        if (cnt == 1) {
                            treeMap.remove(key);
                        } else {
                            treeMap.put(key, cnt - 1);
                        }

                    } else {
                        int key = treeMap.lastKey();
                        int cnt = treeMap.get(key);
                        if (cnt == 1) {
                            treeMap.remove(key);
                        } else {
                            treeMap.put(key, cnt - 1);
                        }
                    }
                }
            }

            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}
