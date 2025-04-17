## 1시 46분 시작.
## 1, 3, 4개를 가져갈 수 있다면
## [n-1] 과 [n-3] 과 [n-4] 직전에 상근이가 이겻다면 -> 창영이의 승리로 이끌 수 있다.
## 만일 이중에 어느 것이라도 창영이의 승리가 있다면, 상근이는 그쪽으로 몰아서 이길 수 있다.
n = int(input())
dp = [True] * (n+1)

if n >= 1:
  dp[1] = True
if n >= 2:
  dp[2] = False
if n >= 3:
  dp[3] = True
if n >= 4:
  dp[4] = True

for i in range(5, n+1):
  dp[i] = not (dp[i-1] and dp[i-3] and dp[i-4])

print("SK" if dp[n] else "CY")
