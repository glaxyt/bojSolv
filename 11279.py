# 11279번 최대 힙
import sys, heapq

heap=[]
n = int(input())
for _ in range(n):
    k = int(sys.stdin.readline())
    if k == 0:
        if heap:
            print((-1)*heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, -1*k)
