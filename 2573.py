# 2573번 빙산
import sys
from collections import deque

dxys = [[1,0],[-1,0],[0,1],[0,-1]]

# bfs 두번 실행
def bfs(s_x, s_y):
    queue = deque([])
    queue.append([s_x, s_y])
    visited[s_y][s_x] = True
    while queue:
        cx, cy = queue.popleft()
        for dx,dy in dxys:
            nx = cx + dx
            ny = cy + dy
            if 0 <= nx < m and 0 <= ny < n and visited[ny][nx] == False:
                # 빙산일 경우에 큐에 넣어준다.
                if grid[ny][nx] != 0:
                    visited[ny][nx] = True
                    queue.append([nx, ny])
                # 빙산의 주변이 바닷물일 경우(nx, ny 좌표) 빙산의 높이가 1 낮아진다. 
                else:
                    if grid[cy][cx] > 0:
                        grid[cy][cx] -= 1
                        
n, m = map(int, input().split())
grid = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]

ans_year = 0

while 1:
    cnt = 0
    ans_year += 1
    visited = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if grid[i][j] != 0 and visited[i][j] == False:
                bfs(j,i)
                cnt += 1
    # bfs가 두번 이상 돌았을 경우 빙산이 두개 이상으로 나뉘어진 경우이다.
    if cnt > 1:
        print(ans_year-1)
        break
    # 빙산이 다 녹았을 경우 0 출력.
    if cnt == 0:
        print(0)
        break
