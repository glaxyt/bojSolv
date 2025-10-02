import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int combo = 0;
            boolean isCloudExist = false;
            for (int j = 0; j < m; j++) {
                char t = line.charAt(j);
                if (t == 'c') {
                    grid[i][j] = 0;
                    isCloudExist = true;
                    combo = 0;
                } else if (isCloudExist) {
                    grid[i][j] = ++combo;
                } else {
                    grid[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
