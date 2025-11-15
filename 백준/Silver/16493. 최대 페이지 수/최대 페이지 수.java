import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 페이지 수 먼저 보여주고, 나서 역순으로 돌려야한다.
        // Why? 1번만 사용가능하고 DP로 가야하기 때문

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int[] dp = new int[n+1];
        List<Book> books = new ArrayList<>();
        for (int i=0; i<m; i++) {
            int[] book = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            books.add(new Book(book[0], book[1]));
        }

        for (Book b : books) {
            for (int i=n; i>=b.time; i--) {
                dp[i] = Math.max(dp[i], dp[i-b.time] + b.page);
            }
        }

        System.out.println(dp[n]);
    }
}

class Book {
    int time;
    int page;

    public Book(int time, int page) {
        this.time = time;
        this.page = page;
    }
}