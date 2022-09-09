# 11286번 절댓값 힙
import sys, heapq
heap = []
k = int(input())
for _ in range(k):
    num = int(sys.stdin.readline())
    if num == 0:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)
    else:
        heapq.heappush(heap, [abs(num), num])
