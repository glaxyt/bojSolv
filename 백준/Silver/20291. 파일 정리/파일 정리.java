import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 확장자를 입력받는다. 정리한다. 사전순으로 출력한다가 끝.
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> extMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] file = br.readLine().split("\\.");
            String ext = file[1];
            extMap.put(ext, extMap.getOrDefault(ext, 0) + 1);
        }

        String[] extArr = new String[extMap.size()];
        int idx = 0;
        for (String ext : extMap.keySet()) {
            extArr[idx++] = ext + " " + extMap.get(ext);
        }

        Arrays.sort(extArr);

        for (String str : extArr) {
            System.out.println(str);
        }
    }

}
