# 13549번 숨바꼭질 3
import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

def rangeValid(v):
    if 0 <= v < 100001:
        return True
    else:
        return False
    
# 다익스트라 알고리즘
def dijkstra(start):
    q=[]
    heapq.heappush(q, (0, start))
    visited[start]=0
    while q:
        dist, now = heapq.heappop(q)
        for i in [now+1, now-1, 2*now]:
            if rangeValid(i):
                if visited[i] > dist:
                    if i == 2*now:
                        visited[i] = dist
                        heapq.heappush(q,(dist, i))
                    else:
                        visited[i] = dist + 1
                        heapq.heappush(q,(dist+1, i))
                

N, K = map(int, input().split())    
visited = [INF] * (100001)
visited[N] = 0
dijkstra(N)
print(visited[K])
