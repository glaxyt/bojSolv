# 9370번 미확인 도착지
# 다익스트라 start - h - g - target와 start - g - h - target 경로 계산
import heapq
import sys
INF = sys.maxsize
input = sys.stdin.readline

def dijkstra(start):
    q = []
    distance = [INF] * (n+1)
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        for v, w in graph[now]:
            cost = dist + w
            if distance[v] > cost:
                distance[v] = cost
                heapq.heappush(q, (cost, v))
    return distance

t = int(input())
for _ in range(t):
    n, m, c = map(int, input().split())
    graph = [[] for i in range(n+1)]
    start, g, h = map(int, input().split())
    target = []
    for _ in range(m):
        a, b, d = map(int, input().split())
        graph[a].append([b, d])
        graph[b].append([a, d])
    for _ in range(c):
        target.append(int(input()))
    from_start = dijkstra(start)
    from_g = dijkstra(g)
    from_h = dijkstra(h)
    ans = []

    for t in target:
        if from_start[g] + from_g[h] + from_h[t] == from_start[t] or from_start[h] + from_h[g] + from_g[t] == from_start[t]:
            ans.append(t)

    # 목적지가 오름차순으로 주어지지않기 때문에 직접 오름차순으로 바꾸어준다.
    ans.sort()

    for i in ans:
        print(i, end=' ')
    print()