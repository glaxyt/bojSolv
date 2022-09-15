# 2161번 카드1
from collections import deque

n = int(input())

queue = deque(list(range(1, n+1)))

while queue:
    print(queue.popleft(), end = " ")
    queue.rotate(-1)

