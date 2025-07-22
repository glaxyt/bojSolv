import java.util.*;

public class Main {
    static PriorityQueue<Integer> bookIdxUpperPq;
    static PriorityQueue<Integer> bookIdxLowerPq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] info = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bookNum = info[0];
        int holdCapacity = info[1];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        bookIdxUpperPq = new PriorityQueue<>(Collections.reverseOrder());
        bookIdxLowerPq = new PriorityQueue<>();

        for (int i = 0; i < bookNum; i++) {
            int bookIdx = Integer.parseInt(st.nextToken());
            if (bookIdx > 0) bookIdxUpperPq.add(bookIdx);
            else bookIdxLowerPq.add(bookIdx);
        }

        System.out.println(getShortestDis(holdCapacity));
    }

    private static int getShortestDis(int holdCapacity) {
        int result = 0;
        int maxOneDirPath = 0;

        while (!bookIdxUpperPq.isEmpty()) {
            int farthest = bookIdxUpperPq.peek();
            maxOneDirPath = Math.max(maxOneDirPath, farthest);
            result += farthest * 2;
            for (int i = 0; i < holdCapacity && !bookIdxUpperPq.isEmpty(); i++) {
                bookIdxUpperPq.remove();
            }
        }

        while (!bookIdxLowerPq.isEmpty()) {
            int farthest = Math.abs(bookIdxLowerPq.peek());
            maxOneDirPath = Math.max(maxOneDirPath, farthest);
            result += farthest * 2;
            for (int i = 0; i < holdCapacity && !bookIdxLowerPq.isEmpty(); i++) {
                bookIdxLowerPq.remove();
            }
        }

        return result - maxOneDirPath;
    }
}
