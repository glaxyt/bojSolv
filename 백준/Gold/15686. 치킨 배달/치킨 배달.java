import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<house> chickenHouse = new ArrayList<>();
    static List<house> customerHouse = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static int n;
    static int m;

    static class house {
        private int x;
        private int y;

        public house(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    customerHouse.add(new house(i, j));
                } else if (row[j] == 2) chickenHouse.add(new house(i, j));
            }
        }
        visited = new boolean[chickenHouse.size()];

        selectChickenHouse(0, 0);

        System.out.println(answer);

    }

    public static void selectChickenHouse(int cnt, int startIdx) {
        if (cnt == m) {
            answer = Math.min(answer, calculateManhattenDistance());
            return;
        }

        for (int i = startIdx; i < chickenHouse.size(); i++) {
            visited[i] = true;
            selectChickenHouse(cnt + 1, i + 1);
            visited[i] = false;
        }
    }

    public static int calculateManhattenDistance() {
        int total = 0;
        for (int i = 0; i < customerHouse.size(); i++) {
            int curMinDistance = Integer.MAX_VALUE;
            for (int j = 0; j < chickenHouse.size(); j++) {
                if (visited[j]) {
                    int manhattenDistance = Math.abs(customerHouse.get(i).x - chickenHouse.get(j).x) + Math.abs(customerHouse.get(i).y - chickenHouse.get(j).y);
                    curMinDistance = Math.min(curMinDistance, manhattenDistance);
                }
            }
            total += curMinDistance;
        }

        return total;
    }
}