# 2636번 치즈
import sys
from collections import deque
input = sys.stdin.readline

m, n = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(m)]
dxys = ((0,1), (1,0), (-1,0), (0,-1))

def bfs(v):
    queue = deque([])
    queue.append([0,0])
    t_visited = v
    t_visited[0][0] = True
    left_cheese = 0
    while queue:
        c_x, c_y = queue.popleft()
        for dx, dy in dxys:
            n_x  = dx + c_x
            n_y = dy + c_y
            if 0 <= n_x < n and 0 <= n_y < m and t_visited[n_y][n_x] == False:
                t_visited[n_y][n_x] = True
                if grid[n_y][n_x] == 0:
                    queue.append([n_x, n_y])
                else:
                    left_cheese += 1
    return left_cheese

ans = 0
cnt = 0
while True:
    visited = [[False]* n for _ in range(m)]
    temp = bfs(visited)
    cnt += 1
    for i in range(m):
        for j in range(n):
            if visited[i][j] == True and grid[i][j] == 1:
                grid[i][j] = 0
    if temp == 0:
        print(cnt-1)
        print(ans)
        break
    else:
        ans = temp
                
    
