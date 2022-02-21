# 11779번 최소비용 구하기 2
import sys
import heapq
INF = sys.maxsize
input = sys.stdin.readline

# 다익스트라 알고리즘
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]:
            continue
        for v, w in graph[now]:
            cost = dist + w
            if cost < distance[v]:
                move[v] = now
                distance[v] = cost
                heapq.heappush(q, (cost, v))

n = int(input())
graph = [[] for _ in range(n+1)]
distance = [INF] * (n+1)
move = [False] * (n+1)
m = int(input())
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
start, end = map(int, input().split())

# 다익스트라 실행
dijkstra(start)

# 출발지부터 도착지까지의 경로를 저장할 리스트.
path=[end]
p = end
while move[p]:
    path.append(move[p])
    p = move[p]

print(distance[end])
print(len(path))
for i in path[::-1]:
    print(i, end=' ')
