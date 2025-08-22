import java.io.*;
import java.util.*;

public class Main {
    static String maxSeq = null;
    static String minSeq = null;
    static String[] sign;
    static int k;
    static boolean[] used = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sign = br.readLine().trim().split(" ");

        dfs(0, new StringBuilder());

        System.out.println(maxSeq);
        System.out.println(minSeq);
    }

    static void dfs(int cnt, StringBuilder seq) {
        if (cnt == k + 1) {
            String s = seq.toString();  // 앞자리 0 유지
            if (maxSeq == null || s.compareTo(maxSeq) > 0) maxSeq = s;
            if (minSeq == null || s.compareTo(minSeq) < 0) minSeq = s;
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (used[d]) continue;

            if (cnt > 0) {
                int left = seq.charAt(cnt - 1) - '0'; // 바로 직전 자리
                String sg = sign[cnt - 1];
                if (sg.equals("<") && !(left < d)) continue;
                if (sg.equals(">") && !(left > d)) continue;
            }

            used[d] = true;
            seq.append((char)('0' + d));
            dfs(cnt + 1, seq);
            seq.setLength(seq.length() - 1);
            used[d] = false;
        }
    }
}
