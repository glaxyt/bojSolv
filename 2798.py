# 2798번 블랙잭
from itertools import combinations as cb

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
minimum = int(1e5)
ans = 0
for args in cb(numbers, 3):
    total = sum(args)
    if total == M:
        ans = M
        break
    elif total < M:
        if minimum > M-total:
            minimum = M-total
            ans = total
    
print(ans)
