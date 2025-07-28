import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int idx = 0;
        int cnt = 0;

        while (idx < P.length()) {
            int len = 1;

            while (idx + len <= P.length() && S.contains(P.substring(idx, idx + len))) {
                len++;
            }
            cnt++;
            idx += len - 1;
        }
        System.out.println(cnt);
    }
}
