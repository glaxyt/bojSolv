class Solution {

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int boardSize = n + 2 * (m - 1);
        int offset = m - 1;

        // 보드 생성
        int[][] board = new int[boardSize][boardSize];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i + offset][j + offset] = lock[i][j];
            }
        }

        for (int r = 0; r < 4; r++) {
            key = getRotatedKey(key); // key 회전

            for (int x = 0; x <= boardSize - m; x++) {
                for (int y = 0; y <= boardSize - m; y++) {
                    if (canOpenLock(board, key, x, y, offset, n)) return true;
                }
            }
        }

        return false;
    }

    private boolean canOpenLock(int[][] board, int[][] key, int x, int y, int offset, int lockSize) {
        int[][] copy = deepCopy(board);

        int m = key.length;

        // key를 board에 덮어보기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                copy[x + i][y + j] += key[i][j];
            }
        }

        // lock 영역이 전부 1인지 확인
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                if (copy[i + offset][j + offset] != 1) return false;
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
                    rotatedKey[y][len - x - 1] = 1;
                }
            }
        }

        return rotatedKey;
    }

    private int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}
