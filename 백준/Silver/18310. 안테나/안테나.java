import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] home = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(home);

        if (n == 1) System.out.println(home[0]);
        else if (n % 2 == 0) System.out.println(home[n / 2 - 1]);
        else System.out.println(home[n / 2]);
    }
}