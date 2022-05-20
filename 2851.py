# 2851번 슈퍼마리오
import sys
s = [int(sys.stdin.readline()) for _ in range(10)]
total = 0
ans = 0
for i in s:
    total += i
    if abs(total - 100) < abs(ans - 100):
        ans = total
    if abs(total-100) == abs(ans - 100):
        ans = max(total, ans)
print(ans)
