# 20922번
# 범위 안에 특정 조건을 일치시켜야 하니 이분 포인트 사용, 완전탐색은 시간초과 가능
## 10시 17분
n, k = map(int, input().split())
nums = list(map(int, input().split()))

def solution():
	right = 0
	left = 0
	count = dict()
	answer = 0
	while right < n:
		right_num = nums[right]
		count[right_num] = count.get(right_num, 0) + 1

		while count[right_num] > k:
			count[nums[left]] -= 1
			left += 1
		
		answer = max(answer, right - left + 1)
		right += 1

	return answer

print(solution())