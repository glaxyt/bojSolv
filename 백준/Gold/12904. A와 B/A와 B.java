import java.util.*;

public class Main {
    static String s;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        String t = sc.next();

        StringBuilder sb = new StringBuilder(t);
        backtrack(sb);

        System.out.println(answer);
    }

    private static void backtrack(StringBuilder sb) {
        if (sb.length() == s.length()) {
            if (sb.toString().equals(s)) {
                answer = 1;
            }
            return;
        }

        if (sb.charAt(sb.length()-1) == 'A') {
            backtrack(sb.delete(sb.length() - 1, sb.length()));
        } else {
            backtrack(sb.delete(sb.length() - 1, sb.length()).reverse());
        }
    }
}
