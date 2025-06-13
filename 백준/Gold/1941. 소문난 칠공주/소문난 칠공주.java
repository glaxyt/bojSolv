import java.io.*;
import java.util.*;

public class Main {

    public static class Location {
        public int x;
        public int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<String> grid = new ArrayList<>();
    static Integer answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String seats = br.readLine();
            grid.add(seats);
        }

        answer = 0;
        backtrack(0, 0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    private static void backtrack(int idx, int total, int somPeo, List<Location> selected) {
        if (total == 7) {
            if (somPeo >= 4 && isConnected(selected)) {
                answer++;
            }
            return;
        }

        if (idx == 25) return;

        int x = idx / 5;
        int y = idx % 5;

        // 현재 위치를 선택하는 경우
        selected.add(new Location(x, y));
        int newSomPeo = (grid.get(x).charAt(y) == 'S') ? somPeo + 1 : somPeo;
        backtrack(idx + 1, total + 1, newSomPeo, selected);
        selected.remove(selected.size() - 1);

        // 현재 위치를 선택하지 않는 경우
        backtrack(idx + 1, total, somPeo, selected);
    }

    private static boolean isConnected(List<Location> selected) {
        if (selected.size() != 7) return false;

        boolean[][] tempVisited = new boolean[5][5];
        Queue<Location> queue = new LinkedList<>();

        // 첫 번째 선택된 위치부터 BFS 시작
        queue.offer(selected.get(0));
        tempVisited[selected.get(0).x][selected.get(0).y] = true;
        int connected = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !tempVisited[nx][ny]) {
                    // 선택된 위치 중 하나인지 확인
                    for (Location loc : selected) {
                        if (loc.x == nx && loc.y == ny) {
                            tempVisited[nx][ny] = true;
                            queue.offer(new Location(nx, ny));
                            connected++;
                            break;
                        }
                    }
                }
            }
        }

        return connected == 7;
    }
}
