# 4963번 섬의 개수
import sys
from collections import deque

dxys = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]

# bfs 함수
def bfs(x, y):
    queue = deque([[x,y]])
    visited[y][x] = True
    while queue:
        cur_x, cur_y = queue.popleft()
        for dx, dy in dxys:
            nx, ny = cur_x + dx, cur_y + dy
            if 0 <= nx < w and 0 <= ny < h and visited[ny][nx] == False and grid[ny][nx] == 1:
                visited[ny][nx] = True
                queue.append([nx, ny])

while True:
    w, h = map(int, input().split())
    if (w,h) == (0,0):
        break
    cnt = 0
    grid = [list(map(int, sys.stdin.readline().split())) for _ in range(h)]
    visited = [[False]*w for _ in range(h)]
    for i in range(h):
        for j in range(w):
            if grid[i][j] == 1 and visited[i][j] == False:
                bfs(j, i)
                cnt += 1
    print(cnt)
