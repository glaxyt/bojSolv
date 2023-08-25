# 7579번 앱
n, m = map(int, input().split())
app_memory = [0] + list(map(int, input().split()))
app_cost = [0] + list(map(int, input().split()))
dp = [[0] * (sum(app_cost)+1) for _ in range(n+1)]
INF = float("inf")
ans = INF

for i in range(1, n+1):
    v = app_memory[i]
    w = app_cost[i]
    for j in range(1, sum(app_cost)+1):
        if w > j:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)

        if dp[i][j] >= m:
            ans = min(ans, j)
if ans == INF:
    print(0)
else:
    print(ans)
