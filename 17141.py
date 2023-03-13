#17141번 연구소 2
import sys, copy
from collections import deque
from itertools import combinations

N, M = map(int, input().split())
cand = []
grid = []
cnt = 0
virus_lo = 0

# 주어지는 격자의 빈칸의 개수, 바이러스를 놓을 수 있는 위치 파악한 뒤 조합을 이용해서 풀이
for y in range(N):
    li = list(map(int, sys.stdin.readline().split()))
    grid.append(li)
    for x in range(N):
        if li[x] == 0:
            cnt += 1
        if li[x] == 2:
            cnt += 1
            cand.append([x,y])
cnt -= M
dxys = ((0,1),(1,0),(-1,0),(0,-1))

# bfs알고리즘 실행 후 바이러스가 전체로 퍼지는 경과 시간 측정.
# 전체로 퍼지지않는다면 -1 출력
def bfs(li, grid):
    t_grid = copy.deepcopy(grid)
    visited = [[-1] * N for _ in range(N)]
    queue = deque([])
    # 감염시킨 칸의 개수
    blank = 0
    # 다른 바이러스자리 다른 숫자로 바꿔줘야
    for i, j in li:
        visited[j][i] = 0
        t_grid[j][i] = 1
        queue.append([i,j])
    maximum = 0
    while queue:
        c_x, c_y = queue.popleft()
        for dx, dy in dxys:
            n_x = c_x + dx
            n_y = c_y + dy
            if 0 <= n_x < N and 0 <= n_y < N and visited[n_y][n_x] == -1 and t_grid[n_y][n_x] in (0,2):
                visited[n_y][n_x] = visited[c_y][c_x] + 1
                blank += 1
                maximum = max(visited[n_y][n_x], maximum)
                queue.append([n_x,n_y])
    # 모든 빈칸을 감염시킬 수 있는 바이러스의 위치였는지 확인
    if blank == cnt:
        return maximum
    else:
        return sys.maxsize
    
ans = sys.maxsize
for li in combinations(cand, M):
    ans = min(bfs(li, grid), ans)

if ans == sys.maxsize:
    print(-1)
else:
    print(ans)


