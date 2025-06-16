import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bf.readLine());

        int num[] = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(num);

        for (int i = 0; i < n; i++) {
            bw.write(num[i] + "\n");
        }

        bw.flush();
    }
}