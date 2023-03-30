# 13565번 침투
import sys
from collections import deque
input = sys.stdin.readline
M, N = map(int, input().split())
grid = [list(input().rstrip()) for _ in range(M)]

dxys = ((0,1), (1,0), (-1,0), (0,-1))
visited = [[False]*N for _ in range(M)]

def bfs(s_x, s_y):
    queue = deque([])
    queue.append([s_x, s_y])
    visited[s_y][s_x] = True
    while queue:
        c_x, c_y = queue.popleft()
        for dx, dy in dxys:
            n_x = c_x + dx
            n_y = c_y + dy
            if 0 <= n_x < N and 0 <= n_y < M and visited[n_y][n_x] == False and grid[n_y][n_x] == "0":
                if n_y == M-1:
                    return True
                visited[n_y][n_x] = True
                queue.append([n_x, n_y])

flag = False
for i in range(N):
    if grid[0][i] == "0":
        flag = bfs(i, 0)
        if flag == True:
            break

if flag:
    print("YES")
else:
    print("NO")
