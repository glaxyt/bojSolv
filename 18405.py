# 18405번 경쟁적 전염
import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
grid = []
queue = []

for i in range(n):
    li = list(map(int, sys.stdin.readline().split()))
    grid.append(li)
    for j in range(n):
        if grid[i][j] != 0:
            queue.append([0, li[j], j, i])
            
queue.sort()
queue = deque(queue)

s, fx, fy = map(int, sys.stdin.readline().split())
dxys = ((1,0), (-1,0), (0,1), (0,-1))

# 전염 경과 시간, 바이러스 번호
def bfs():
    while queue:
        t, v, cx, cy = queue.popleft()
        if t == s:
            return
        for dx, dy in dxys:
            nx = cx + dx
            ny = cy + dy
            if 0 <= nx < n and 0 <= ny < n and grid[ny][nx] == 0:
                grid[ny][nx] = v
                queue.append([t+1, v, nx, ny])
bfs()
print(grid[fx-1][fy-1])

