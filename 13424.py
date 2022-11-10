# 13424번 비밀 모임
import heapq
import sys
input = sys.stdin.readline
INF = 10**9

def dijkstra(start, graph, distant):
    dis = distant
    q = []
    heapq.heappush(q, (0, start))
    dis[start] = 0
    while q:
        d, now = heapq.heappop(q)
        if dis[now] < d:
            continue
        for v, w in graph[now]:
            cost = d + w
            if cost < dis[v]:
                dis[v] = cost
                heapq.heappush(q, (cost, v))
    return dis
                
def solve():    
    t = int(input())
    for _ in range(t):
        V, E = map(int, input().split())
        ans = [0] * (V+1)
        ans[0] = INF
        graph = [[] for _ in range(V+1)]
        for _ in range(E):
            a, b, c = map(int, input().split())
            graph[a].append((b, c))
            graph[b].append((a, c))
        fr = int(input())
        fr_location = list(map(int, input().split()))
        for s_v in fr_location:
            li = dijkstra(s_v, graph, [INF] * (V+1))
            for i in range(1, V+1):
                ans[i] += li[i]
        minimum = INF
        for j in range(1, V+1):
            if ans[j] < minimum:
                ans_vertex = j
                minimum = ans[j]
        print(ans_vertex)
    
solve()
