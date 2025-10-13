import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<String> forms = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int k = input[1];

        findKthForm(n, 0, "");

        if (forms.size() < k) {
            System.out.println(-1);
        } else {
            System.out.println(forms.get(k - 1));
        }
    }

    private static void findKthForm(int n, int result, String form) {
        if (result == n) {
            forms.add(form.substring(1));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (result + i > n) continue;
            findKthForm(n, result + i, form + "+" + i);
        }
    }
}
