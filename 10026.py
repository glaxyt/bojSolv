# 10026번 적록색약
import sys
from collections import deque

def bfs(graph):
    ans = 0
    visited = [[False] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if visited[i][j] == False:
                ans += 1
                queue = deque()
                queue.append((j,i))
                visited[i][j] = True
                color = graph[i][j]
                while queue:
                    x, y= queue.popleft()
                    for a in range(4):
                        nx = x + dx[a]
                        ny = y + dy[a]
                        if 0 <= nx < n and 0 <= ny < n:
                            if visited[ny][nx] == False and graph[ny][nx] == color:
                                visited[ny][nx] = True
                                queue.append((nx, ny))
    return ans

# 좌표 이동 값
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
n = int(input())
# 정상인이 보는 그림
graph_normal = [sys.stdin.readline().rstrip() for _ in range(n)]
# 적록색약 사람이 보는 그림
graph_red_green = [i.replace("R","G") for i in graph_normal]  # 문자열 replace함수를 사용 

normal = bfs(graph_normal)
weak_eyes = bfs(graph_red_green)

print(f'{normal} {weak_eyes}')
