import java.util.*;
import java.io.*;

public class Main {
    static int answer = 0;
    static String[] VOWEL = {"a", "e", "i", "o", "u"};
    static List<String> path;
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();

        // 다음 a줄 만큼 정수 입력받아 배열에 저장
        String[] charSet = new String[C];
        for (int i = 0; i < C; i++) {
            charSet[i] = sc.next();
        }

        Arrays.sort(charSet);
        path = new ArrayList<>();

        backtracking(L, C, charSet, 0);
    }

    // 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.
    private static void backtracking(int L, int C, String[] charSet, int startIdx) {
        // 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다.
        if (path.size() == L) {
            if (!isValidWord(path)) return;
            System.out.println(String.join("", path));
            return;
        }

        // 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
        for (int idx = startIdx; idx < C; idx++) {
            path.add(charSet[idx]);
            backtracking(L, C, charSet, idx + 1);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isValidWord(List<String> path) {
        int cnt = 0;
        for (String v : VOWEL) {
            if (path.contains(v)) {
                cnt++;
            }
        }

        if (cnt == 0) return false;
        if (path.size() - cnt < 2) return false;
        return true;
    }
}
