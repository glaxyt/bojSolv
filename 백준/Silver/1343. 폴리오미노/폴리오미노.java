import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        int len = 0;

        for (int i = 0; i < board.length(); i++) {
            char s = board.charAt(i);

            if (s == '.') {
                if (len % 2 != 0) {
                    flag = false;
                    break;
                }

                while (len > 2) {
                    sb.append("AAAA");
                    len -= 4;
                }
                if (len == 2) sb.append("BB");

                sb.append(".");
                len = 0;
                continue;
            }
            len++;
        }

        if (len % 2 != 0) {
            flag = false;
        } else {
            while (len > 2) {
                sb.append("AAAA");
                len -= 4;
            }
            if (len == 2) sb.append("BB");
        }

        if (flag) {
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }
}