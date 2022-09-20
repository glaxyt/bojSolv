# 10797번 10부제
target = input()
nums = input().split()
ans = 0
for i in nums:
    if i[-1] == target:
        ans += 1
print(ans)
