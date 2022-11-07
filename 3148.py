# 3184번 양
# r 행 c 열  .빈 필드 # 울타리 o 양 v 늑대
from collections import deque

r, c = map(int, input().split())
grid  = [ list(input()) for _ in range(r)]
visited = [[False]*c for _ in range(r)]

dxs = [0, 0, 1, -1]
dys = [1, -1, 0, 0]

ans_sheep = 0
ans_wolf  = 0

def bfs(s_x, s_y):
    global ans_sheep
    global ans_wolf
    wolf = 0
    sheep = 0
    queue = deque([[s_x, s_y]])
    visited[s_y][s_x] = True
    
    if grid[s_y][s_x] == 'v':
        wolf += 1
    elif grid[s_y][s_x] == 'o':
        sheep += 1
        
    while queue:
        c_x, c_y = queue.popleft()
        for dx, dy in zip(dxs, dys):
            n_x = c_x + dx
            n_y = c_y + dy
            if 0 <= n_x < c and 0 < n_y < r and visited[n_y][n_x] == False and not grid[n_y][n_x] == '#':
                if grid[n_y][n_x] == 'v':
                    wolf += 1
                elif grid[n_y][n_x] == 'o':
                    sheep += 1
                visited[n_y][n_x] = True
                queue.append([n_x, n_y])
    
    if sheep > wolf:
        ans_sheep += sheep
        return
    else:
        ans_wolf += wolf
        return


for i in range(r):
    for j in range(c):
        if not grid[i][j] == "#" and visited[i][j] == False:
            bfs(j, i)

print(ans_sheep, ans_wolf)
