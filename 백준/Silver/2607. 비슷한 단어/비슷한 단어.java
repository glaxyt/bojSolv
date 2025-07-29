import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        String word = br.readLine();
        Map<Character, Integer> standardWordCharMap = getCharCount(word);

        for (int i = 0; i < n - 1; i++) {
            String tempWord = br.readLine();
            Map<Character, Integer> tempMap = getCharCount(tempWord);
            if (compareMap(word, tempWord, standardWordCharMap, tempMap)) answer++;
        }
        System.out.println(answer);
    }

    private static boolean compareMap(String standardWord, String tempWord, Map<Character, Integer> standardWordCharMap, Map<Character, Integer> tempMap) {
        // 길이 차이가 1보다 크면 비슷하지 않음
        if (Math.abs(standardWord.length() - tempWord.length()) > 1) {
            return false;
        }

        int diff = 0;
        Set<Character> allChars = new HashSet<>();
        allChars.addAll(standardWordCharMap.keySet());
        allChars.addAll(tempMap.keySet());

        for (Character c : allChars) {
            int count1 = standardWordCharMap.getOrDefault(c, 0);
            int count2 = tempMap.getOrDefault(c, 0);
            diff += Math.abs(count1 - count2);
        }

        return diff <= 2;
    }

    private static Map<Character, Integer> getCharCount(String word) {
        char[] charArray = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }
}
