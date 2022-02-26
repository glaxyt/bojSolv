# 11780번 플로이드 2
import sys
input = sys.stdin.readline
INF = sys.maxsize

n = int(input())
m = int(input())
# 간선 정보를 저장할 2차원 리스트
graph = [[INF]*(n+1) for _ in range(n+1)]
# 지나온 경로를 저장할 2차원 리스트
visit = [[INF]*(n+1) for _ in range(n+1)]

# 간선 저장, 최단경로 출발지 저장
for _ in range(m):
    a, b, c = map(int, input().split())
    if graph[a][b] > c:
        graph[a][b] = c
        visit[a][b] = a

# 자신으로부터 자신은 비용이 0
for a in range(1, n+1):
    for b in range(1, n+1):
        if a == b:
            graph[a][b] = 0

# 최단경로 계산, 만일 최단경로라면 이전에 저장해놓은 visit을 불러온다.
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            if graph[a][b] > graph[a][k] + graph[k][b]:
                graph[a][b] = graph[a][k] + graph[k][b]
                visit[a][b] = visit[k][b]

# 제작한 플로이드와셜 표 출력
for a in range(1, n+1):
    for b in range(1, n+1):
        print(0 if graph[a][b] == INF else graph[a][b], end = ' ')
    print()

for a in range(1, n+1):
    for b in range(1, n+1):
        # 만일 경로가 존재하지않다면 visit에서 출발지가 없는 INF로 저장해놨을것이다.
        if visit[a][b] == INF:
            print(0)
            continue
        else:
            # 도착지를 미리 넣어놓은 경로 리스트 작성.
            path= [b]
            idx = b
            while(idx != a):
                path.append(visit[a][idx])
                idx = visit[a][idx]
            print(len(path), *path[::-1])

