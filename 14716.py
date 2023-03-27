# 14716번 현수막
import sys
from collections import deque

dxys = ((1,0), (-1,0), (0,1), (0,-1), (1,1), (1,-1),(-1,1),(-1,-1))

M, N = map(int, input().split())
grid = [sys.stdin.readline().rstrip().split() for _ in range(M)]
def bfs(s_x, s_y):
    queue = deque([])
    queue.append([s_x, s_y])
    visited[s_y][s_x] = True
    while queue:
        c_x, c_y = queue.popleft()
        for dx, dy in dxys:
            n_x = c_x + dx
            n_y = c_y + dy
            if 0 <= n_x < N and 0 <= n_y < M and visited[n_y][n_x] == False and grid[n_y][n_x] == '1':
                visited[n_y][n_x] = True
                queue.append([n_x,n_y])

cnt = 0
visited = [[False]*N for _ in range(M)]

for i in range(M):
    for j in range(N):
        if grid[i][j] == '1' and visited[i][j] == False:
            bfs(j,i)
            cnt += 1

print(cnt)
