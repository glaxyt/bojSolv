# 10826번 피보나치 수 4
n = int(input())
dp = [0, 1]
for i in range(2, n+1):
    dp.append(dp[i-2] + dp[i-1])
print(dp[n])
