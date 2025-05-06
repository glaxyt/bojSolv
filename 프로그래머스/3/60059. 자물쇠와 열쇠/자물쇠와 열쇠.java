class Solution {

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        for (int i = 0; i < 4; i++) {
            key = getRotatedKey(key);

            for (int mx = -key.length + 1; mx < lock.length; mx++) {
                for (int my = -key.length + 1; my < lock.length; my++) {
                    if (canOpenLock(key, lock, mx, my)) return true;
                }
            }
        }

        return answer;
    }

    private boolean canOpenLock(int[][] key, int[][] lock, int mx, int my) {
        int n = lock.length;
        int m = key.length;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int keyX = x - mx;
                int keyY = y - my;

                int keyVal = 0;
                if (0 <= keyX && keyX < m && 0 <= keyY && keyY < m) {
                    keyVal = key[keyX][keyY];
                }

                int sum = lock[x][y] + keyVal;
                if (sum != 1) return false;
            }
        }

        return true;
    }

    private int[][] getRotatedKey(int[][] key) {
        int len = key.length;
        int[][] rotatedKey = new int[len][len];

        for (int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                if (key[x][y] == 1) {
                    int newX = y;
                    int newY = len - x - 1;
                    rotatedKey[newX][newY] = 1;
                }
            }
        }

        return rotatedKey;
    }
}
