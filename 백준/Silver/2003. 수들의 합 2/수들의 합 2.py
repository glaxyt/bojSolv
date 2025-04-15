n, k = map(int, input().split())
nums = list(map(int, input().split()))

dp = [0]
total = 0
for i in range(n):
  total += nums[i]
  dp.append(total)

answer = 0
left = 1
right = 1
while right <= n:
  result = dp[right] - dp[left-1]
  if result >= k:
    if result == k:
      answer += 1
    left += 1
  else:
    right += 1

print(answer)