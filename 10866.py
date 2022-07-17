# 10866번 덱
from collections import deque
import sys

n = int(input())
queue = deque()
for _ in range(n):
    li = sys.stdin.readline().rstrip().split()
    order = li[0]
    if order == "push_front":
        queue.appendleft(int(li[1]))
    elif order == "push_back":
        queue.append(int(li[1]))
    elif order == "pop_front":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif order == "pop_back":
        if queue:
            print(queue.pop())
        else:
            print(-1)
    elif order == "size":
        print(len(queue))

    elif order == "empty":
        if queue:
            print(0)
        else:
            print(1)
    elif order == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    else:
        if queue:
            print(queue[-1])
        else:
            print(-1)
