import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int n = input[0];
        int l = input[1];
        Integer[] fruits = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.sort(fruits, (a, b) -> a - b);
        for (int fruit : fruits) {
            if (fruit <= l) {
                l++;
            }
        }
        System.out.println(l);
    }
}
