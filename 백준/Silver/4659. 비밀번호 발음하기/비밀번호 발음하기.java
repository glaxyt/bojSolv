import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] VOWEL = { "a", "e", "i", "o", "u" };
    static String V = "V";
    static String C = "C";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = "";
        while ((word = br.readLine()) != null) {
            if (word.equals("end")) break;

            if (!solve(word)) {
                System.out.println("<" + word + "> is not acceptable.");
            } else {
                System.out.println("<" + word + "> is acceptable.");
            }
        }
    }

    private static boolean solve(String word) {
        if (!validateVowelWordContain(word)) return false;
        if (!validateSequence(word)) return false;
        return true;
    }

    private static boolean validateVowelWordContain(String word) {
        boolean result = false;
        for (String s : VOWEL) {
            if (word.contains(s)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean validateSequence(String word) {
        int cnt = 1;
        String exStringType = "";
        String curStringType;
        for (int i = 0; i < word.length(); i++) {
            String s = String.valueOf(word.charAt(i));

            if (isVowel(s)) {
                curStringType = V;
            } else {
                curStringType = C;
            }

            if (curStringType.equals(exStringType)) {
                cnt++;
                if (cnt == 3) {
                    return false;
                }
            } else {
                cnt = 1;
                exStringType = curStringType;
            }

            if (i > 0) {
                String prev = String.valueOf(word.charAt(i - 1));
                if (s.equals(prev) && !(s.equals("e") || s.equals("o"))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isVowel(String s) {
        return Arrays.asList(VOWEL).contains(s);
    }
}
