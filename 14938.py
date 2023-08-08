# 14938번 서강그라운드
import sys
INF = sys.maxsize
n, m, r = map(int, input().split())
item = list(map(int, input().split()))
graph = [[INF] * (n) for i in range(n)]
for _ in range(r):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a-1][b-1] = c
    graph[b-1][a-1] = c

for i in range(n):
    for j in range(n):
        if i == j:
            graph[i][j] = 0

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

ans = 0
for i in range(n):
    total = 0
    for j in range(n):
        if graph[i][j] <= m:
            total += item[j]
    ans = max(total, ans)

print(ans)




