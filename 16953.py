# 16953번 A → B
from collections import deque

a, b = map(int, input().split())

def bfs():
    queue = deque([])
    queue.append([0, a])
    while queue:
        cnt, c_a = queue.popleft()
        if c_a < b:
            queue.append([cnt+1, c_a*2])
            queue.append([cnt+1, int(str(c_a)+"1")])
        if c_a == b:
            return cnt+1

    return -1

print(bfs())
