# 18258번 큐 2
from collections import deque
import sys

input = sys.stdin.readline

n = int(input())
queue = deque([])
for _ in range(n):
    order = input().rstrip().split()
    haveToDo = order[0]

    if haveToDo == "push":
        queue.append(order[1])
    elif haveToDo == "pop":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif haveToDo == "size":
        print(len(queue))

    elif haveToDo == "empty":
        if queue:
            print(0)
        else:
            print(1)
    elif haveToDo == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif haveToDo == "back":
        if queue:
            print(queue[-1])
        else:
            print(-1)
