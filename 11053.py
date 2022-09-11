# 11053번 가장 긴 증가하는 부분 수열, Longest Increasing Subsequence
import sys

N = int(input())
nums = list(map(int, sys.stdin.readline().split()))
dp = [1] * N

for i in range(1, N):
    for j in range(i):
        if nums[i] > nums[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp))
