# 14235번 크리스마스 선물
from heapq import heappush, heappop
n = int(input())
values = []

for _ in range(n):
    a = list(map(int, input().split()))
    if a[0] == 0:
        # 아이를 만났고 선물이 있는 경우
        if values:
            print(heappop(values)[1])
        # 아이를 만났지만, 선물이 없는 경우
        else:
            print(-1)
    else:
        for i in range(1, a[0]+1):
            heappush(values, [-a[i], a[i]])
        

