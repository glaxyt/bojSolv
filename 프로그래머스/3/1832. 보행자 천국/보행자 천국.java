class Solution {
    static int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        
        // 자동차는 오른쪽 혹은 아래로만 이동 가능
        // 도로 상황에 맞는 움직임이 요구된다.
        // 0 은 자동차 지나갈 수 있다.
        // 1은 지나갈 수 없다.
        // 2는 좌회전이나 우회전이 금지된다.
        // 차의 방향을 고려해야한다.왼쪽에서 오는 차 -> 는 오른쪽으로만
        // 아래로 가는 차는 아래로만 가능
        // 이동 가능한 모든 전체 경로 개수 찾기
        
        int[][] down = new int[m][n];
        int[][] right = new int[m][n];

        down[0][0] = 1;
        right[0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                if (cityMap[i][j] == 1) {
                    down[i][j] = 0;
                    right[i][j] = 0;
                    continue;
                }

                if (i > 0) {
                    int sign = cityMap[i - 1][j];
                    if (sign == 0) {
                        down[i][j] = (down[i][j] + down[i - 1][j] + right[i - 1][j]) % MOD;
                    } else if (sign == 2) {
                        down[i][j] = (down[i][j] + down[i - 1][j]) % MOD;
                    }
                }

                if (j > 0) {
                    int sign = cityMap[i][j - 1];
                    if (sign == 0) {
                        right[i][j] = (right[i][j] + down[i][j - 1] + right[i][j - 1]) % MOD;
                    } else if (sign == 2) {
                        right[i][j] = (right[i][j] + right[i][j - 1]) % MOD;
                    }
                }
            }
        }

        return (down[m - 1][n - 1] + right[m - 1][n - 1]) % MOD;
    }
}