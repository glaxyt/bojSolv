# 3273번 두 수의 합
n = int(input())
nums = list(map(int, input().split()))
nums.sort()
key = int(input())
left, right = 0, n-1
ans = 0
while left < right:
    total = nums[left] + nums[right]
    if key == total:
        ans += 1
    if total < key:
        left += 1
        continue
    right -= 1
print(ans)
        
