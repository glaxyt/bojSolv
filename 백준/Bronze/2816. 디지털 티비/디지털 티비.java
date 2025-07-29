import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String KBS1 = "KBS1";
    static String KBS2 = "KBS2";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> channels = new ArrayList<>();

        int kbs1_loc = 0;
        int kbs2_loc = 0;

        for (int i = 0; i < n; i++) {
            // 2가지 방법으로 채널을 옮긴다.
            // 1. kbs를 찾아서 위로 올리기
            // 2. kbs를 찾을 때까지 위에 것을 아래로 내리기
            String channel = br.readLine();
            if (channel.equals(KBS1)) kbs1_loc = i;
            if (channel.equals(KBS2)) kbs2_loc = i;
        }

        if (kbs1_loc > kbs2_loc) kbs2_loc++;

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < kbs1_loc; i++) {
            answer.append("1");
        }

        for (int i = 0; i < kbs1_loc; i++) {
            answer.append("4");
        }

        for (int i = 0; i < kbs2_loc; i++) {
            answer.append("1");
        }

        for (int i = 1; i < kbs2_loc; i++) {
            answer.append("4");
        }

        System.out.println(answer);
    }
}
