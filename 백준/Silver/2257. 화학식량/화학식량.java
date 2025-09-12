import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] formula;
    static Map<Character, Integer> map = Map.of('C', 12, 'H', 1, 'O', 16);
    static int idx = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 재귀로 풀 수 있지않을까? 괄호가 안에 재귀적으로 존재한기 때문에.
        // 그리디 방식? 생각이 안난다.
        // 뒤에 숫자를 어떻게 계산 할 것 인가.
        // C3HO -> C는 3을 곱해줘야한다.
        // H는 1
        // O는 1
        // 1이 안적혀있기 때문에, 뒤에 문자가 ) 나 원소가 나오면 1로 처리해야한다.

        formula = br.readLine().toCharArray();
        System.out.println(dfs());
    }

    private static int dfs() {
        int result = 0;

        while (idx < formula.length) {
            char ch = formula[idx];

            if (ch == '(') {
                idx++;
                result += dfs();
            } else if (ch == ')') {
                idx++;
                int multiplier = getBackNum();
                return result * multiplier;
            } else {
                idx++;
                result += map.get(ch) * getBackNum();
            }
        }

        return result;
    }

    private static int getBackNum() {
        if (idx < formula.length && Character.isDigit(formula[idx])) {
            return formula[idx++] - '0';
        }
        return 1;
    }
}