# 2467번 용액
import sys

n = int(input())
liquid = list(map(int, input().split()))
start = 0
end = n-1
closeToEnd = sys.maxsize 
ans = [0,0]
while start < end:
    total = liquid[start] + liquid[end]
    if abs(total) < closeToEnd:
        closeToEnd = abs(total)
        ans[0], ans[1] = liquid[start], liquid[end]
    elif total > 0:
        end -=1
    else:
        start += 1

print(*ans)
