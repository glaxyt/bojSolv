# 14497번 주난의 난(難)
from collections import deque
import sys

def bfs(s_x, s_y):
    dxys = ((0,1), (0,-1), (1,0), (-1,0))
    queue = deque([[s_x, s_y]])
    visited[s_y][s_x] = 0
    while queue:
        c_x, c_y = queue.popleft()
        for  dx, dy in dxys:
            n_x = c_x + dx
            n_y = c_y + dy
            if 0 <= n_x < M and 0 <= n_y < N and visited[n_y][n_x] == -1:
                if grid[n_y][n_x] == "1" or grid[n_y][n_x] == "#":
                    visited[n_y][n_x] = visited[c_y][c_x] + 1
                    queue.append([n_x, n_y])
                else:
                    visited[n_y][n_x] = visited[c_y][c_x]
                    queue.appendleft([n_x, n_y])   # appendleft()를 통해서 방문할 수 있는 0부터 방문할 수 있게 deque에 넣어줍니다.

N, M = map(int, sys.stdin.readline().split())
y1, x1, y2, x2 = map(int, sys.stdin.readline().split())
grid = [list(sys.stdin.readline().rstrip()) for _ in range(N)]
visited = [[-1 for _ in range(M)] for _ in range(N)]
bfs(x1-1, y1-1)
print(visited[y2-1][x2-1])
