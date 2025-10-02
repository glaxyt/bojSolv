import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        
        int digits = 1;
        int total = 0;
        int count = 2;

        while (total + count < k) {
            total += count;
            digits++;
            count *= 2;
        }

        int position = k - total - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = digits - 1; i >= 0; i--) {
            int bit = (position >> i) & 1;
            if (bit == 0) {
                sb.append('4');
            } else {
                sb.append('7');
            }
        }

        System.out.println(sb.toString());
    }
}
