# 11404번 플로이드
import sys
input = sys.stdin.readline
INF = sys.maxsize

n = int(input())
m = int(input())
graph = [[INF]*(n+1) for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)

for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            graph[i][j] = 0

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(1, n+1):
    for j in graph[i][1:]:
        if j == INF:
            j = 0
        print(j, end=' ')
    print()
                
