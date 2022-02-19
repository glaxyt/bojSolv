# 10282번 해킹 
import sys
import heapq
input = sys.stdin.readline
INF = sys.maxsize

# 다익스트라 알고리즘
def dijkstra(start):
    q=[]
    heapq.heappush(q, (0, start))
    distance[start]=0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for v, w in graph[now]:
            cost = dist + w
            if cost < distance[v]:
                distance[v] = cost
                heapq.heappush(q,(cost, v))

t = int(input())
for _ in range(t):
    n, d, c = map(int, input().split())
    graph = [[] for i in range(n+1)]
    distance = [INF]*(n+1)
    cnt = 0
    for _ in range(d):
        a, b, s = map(int, input().split())
        graph[b].append((a, s))
    dijkstra(c)
    maximum = 0
    # 감염되지않은 컴퓨터 중에서 출력
    for i in distance:
        if i != INF:
            maximum = max(maximum, i)
            cnt += 1
    print(cnt, maximum)
