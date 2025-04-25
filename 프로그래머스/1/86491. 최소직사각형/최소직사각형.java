import java.util.*;

class Solution {
    static int maxW = Integer.MIN_VALUE;
    static int maxH = Integer.MIN_VALUE;
    public int solution(int[][] sizes) {
        for (int[] size : sizes) {
            Arrays.sort(size);
            maxW = Math.max(maxW, size[0]);
            maxH = Math.max(maxH, size[1]);
        }
        return maxW * maxH;
    }
}
