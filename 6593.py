# 6593번 상범 빌딩
import sys
from collections import deque

dxyzs = ((0,0,1), (0,0,-1), (1,0,0), (-1,0,0), (0,1,0), (0,-1,0))

while True:
    L, R, C = map(int, sys.stdin.readline().split())

    if L == 0:
        break
    
    ex, ey, ez = 0, 0, 0
    grid = []
    visited = [[[False]*C for _ in range(R)] for _ in range(L)]
    queue = deque([])
    
    for z in range(L):
        floor = []
        for y in range(R):
            li = list(sys.stdin.readline().rstrip() )
            floor.append(li)
            for x in range(C):
                if li[x] == 'S':
                    visited[z][y][x] = 1
                    queue.append([x, y, z])
                if li[x] == 'E':
                    ex, ey, ez = x, y, z
        sys.stdin.readline()
        grid.append(floor)

    flag = False
    while queue:
        cx, cy, cz = queue.popleft()
        
        if grid[cz][cy][cx] == "E":
            flag = True
            break
        
        for dx, dy, dz in dxyzs:
            nx = cx + dx
            ny = cy + dy
            nz = cz + dz
            if 0 <= nx < C and 0 <= ny < R and 0 <= nz < L and grid[nz][ny][nx] != "#" and visited[nz][ny][nx] == False:
                visited[nz][ny][nx] = visited[cz][cy][cx] + 1
                queue.append([nx, ny, nz])

    if flag:
        print(f'Escaped in {visited[ez][ey][ex] - 1} minute(s).')
    else:
        print("Trapped!")    
        
