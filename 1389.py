# 1389번 케빈 베이컨의 6단계 법칙
import sys
INF = sys.maxsize
m, n = map(int, input().split())
graph = [[INF]*(m+1) for i in range(m+1)]
for _ in range(n):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

for k in range(1, m+1):
    for i in range(1, m+1):
        for j in range(1, m+1):
            if i==j:
                graph[i][j] = 0
            else:
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


ans = 0
minimum = INF
for i in range(1, m+1):
    total = 0
    for j in range(1, m+1):
        total += graph[i][j]
    if total < minimum:
        minimum = total
        ans = i
print(ans)
