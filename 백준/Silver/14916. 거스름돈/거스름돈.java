import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int fiveCoin = n / 5;
        n -= fiveCoin * 5;

        int secondCoin = n / 2;
        n -= secondCoin * 2;

        if (n > 0 && n <= fiveCoin) {
            fiveCoin -= n;
            secondCoin += (n * 3);
            n = 0;
        }

        if (n > 0) {
            System.out.println(-1);
        } else {
            System.out.println(secondCoin + fiveCoin);
        }
    }
}
