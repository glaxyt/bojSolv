# 1788번 피보나치 수의 확장
n = int(input())
dp = [0, 1, 1]
for i in range(3, abs(n)+1):
    dp.append((dp[i-2] + dp[i-1])%1000000000)
        
if n > 0:
    print(1, dp[-1], sep="\n")
elif n < 0:
    if n % 2 == 0:
        sign = -1
    else:
        sign = 1       
    print(sign, dp[-1], sep="\n")
else:
    print(0, 0)
