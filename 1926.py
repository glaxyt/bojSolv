# 1926번 그림
from collections import deque
import sys

dxs = [0, 0, 1, -1]
dys = [1, -1, 0, 0]
grid = []

n, m = map(int, input().split())
for _ in range(n):
    grid.append(list(map(int, sys.stdin.readline().split())))
visited = [[0 for _ in range(m)] for _ in range(n)]

def bfs(start_x, start_y):
    queue = deque([])
    queue.append([start_x, start_y])
    cnt = 1
    visited[start_y][start_x] = 1
    while queue:
        c_x, c_y = queue.pop()
        for dx, dy in zip(dxs, dys):
            n_x = c_x + dx
            n_y = c_y + dy
            if 0 <= n_x < m and 0 <= n_y < n and visited[n_y][n_x] == 0 and grid[n_y][n_x] == 1:
                visited[n_y][n_x] = 1
                queue.append([n_x, n_y])
                cnt += 1
    return cnt

pic_max  = 0
pic_cnt = 0
for i in range(n):
    for j in range(m):
        if visited[i][j] == 0 and grid[i][j] == 1:
            pic_max = max(bfs(j, i), pic_max)
            pic_cnt += 1
            
print(pic_cnt, pic_max, sep="\n")

