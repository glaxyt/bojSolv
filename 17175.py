# 17175번 피보나치는 지겨웡~
n = int(input())
dp = [1,1,3]
for i in range(3, n+1):
    dp.append((dp[i-1] + dp[i-2] + 1)%1000000007)

print(dp[n])
