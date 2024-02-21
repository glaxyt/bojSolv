# 11051번 이항 계수2
import sys
n, k = map(int, input().split())

def bin_coef():
    dp = [[0 for _ in range(k + 1)] for _ in range(n + 1)]
    for i in range(n + 1):
        dp[i][0] = 1
    for j in range(k + 1):
        dp[j][j] = 1

    for i in range(1, n + 1):
        for j in range(1, k + 1):
            dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % 10007
    return dp

ans = bin_coef()

print(ans[n][k])
