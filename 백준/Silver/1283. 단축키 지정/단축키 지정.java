import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 명령어 개수
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        // 명령어 N줄 입력 받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();  // 한 줄 전체 입력
            // 여기서 line을 가공하거나 로직을 수행하면 됨
            list.add(line);
        }

        Map<Character, Integer> map = new HashMap();

        for (String words : list) {
            int idx = 0;
            boolean found = false;
            StringBuilder sb = new StringBuilder(words);
            for (int i = 0; i < words.split(" ").length; i++) {
                String word = words.split(" ")[i];
                char key = Character.toLowerCase(word.charAt(0));
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                    sb.insert(idx, '[');
                    sb.insert(idx + 2, ']'); // 앞에 문자 추가로 밀렸기 때문에 +2
                    answer.add(sb.toString());
                    found = true;
                    break;
                }
                idx += word.length() + 1;
            }

            if (found) continue;

            for (int i = 0; i < words.length(); i++) {
                char key = Character.toLowerCase(sb.charAt(i));
                if (!(map.containsKey(key) || key == ' ')) {
                    map.put(key, 1);
                    sb.insert(i, '[');
                    sb.insert(i + 2, ']'); // 앞에 문자 추가로 밀렸기 때문에 +2
                    answer.add(sb.toString());
                    found = true;
                    break;
                }
            }
            if (!found) answer.add(sb.toString());
        }

        for (String w : answer) {
            System.out.println(w);
        }
    }
}
