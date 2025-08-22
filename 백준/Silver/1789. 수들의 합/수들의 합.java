import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long value = 1;
        long answer = 0;
        while (n > 0) {
            if (n < value) {
                break;
            }
            n -= value;
            answer++;
            value++;
        }
        System.out.println(answer);
    }
}
