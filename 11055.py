# 11055번 가장 큰 증가하는 부분 수열
n = int(input())
nums = list(map(int, input().split()))
# 누적값 저장해줄 리스트.
dp = [0] * n

# 초기값 설정.
dp[0] = nums[0]

for i in range(1, n):
    for j in range(n):
        # 증가수열을 만족하는 경우들 중 최대값을 구해준다.
        if nums[i] > nums[j]:
            dp[i] = max(dp[i], nums[i] + dp[j])
        # 증가수열을 만족하지 못한다면. 해당값에서 증가수열을
        # 시작한 값과 누적된 최댓값과 비교
        else:
            dp[i] = max(dp[i], nums[i])
print(max(dp))
