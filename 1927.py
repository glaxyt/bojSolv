# 1927번 최소 힙
import sys, heapq
heap = []
n = int(sys.stdin.readline())
for _ in range(n):
    k = int(sys.stdin.readline())
    if k == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, k)
