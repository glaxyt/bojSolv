n = int(input())
dp = [0 for _ in range(n+1)]

def solution():
    dp[0] = 1
    dp[1] = 3
    for i in range(2, n+1):
        dp[i] = (2 * dp[i-1] + dp[i-2]) % 9901

    return dp[n]

print(solution())