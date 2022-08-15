# 7567번 토마토
from collections import deque
import sys

# 입력값으로 가로 세로를 받아준다.
M, N = map(int, input().split())

# 창고를 구현해줄 이중리스트 grid를 구현해준다.
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

# 최소 일 수를 표현할 정수 변수
days_ans = 0

# 덱 구현
queue = deque()

# 익은 토마토가 효력을 발휘할 수 있는 범위
dxys = ((0,1),(0,-1),(1,0),(-1,0))

def bfs():
    while queue:
        cur_x, cur_y = queue.popleft()
        for dx, dy in dxys:
            nx, ny = cur_x + dx, cur_y + dy
            if 0 <= nx < M and 0 <= ny < N and grid[ny][nx] == 0:
                grid[ny][nx] =  grid[cur_y][cur_x] + 1
                queue.append([nx, ny])

# 익은 토마토의 위치를 파악하여 deque에 넣어준다.
for y in range(N):
    for x in range(M):
        if grid[y][x] == 1:
            queue.append([x,y])
                
# bfs함수를 실행.           
bfs()

# 창고 안의 토마토가 전부 익었는지 확인하고 만일 전부 익지않았다면 -1 출력
# 전부 익었다면 걸린 최소 일 수를 출력
for i in range(N):
    for j in range(M):
        if grid[i][j] == 0:
            print(-1)
            exit(0)
        days_ans = max(days_ans, grid[i][j])

# 익은 토마토가 창고 안에서 1로 표현된다는 것을 이용하여 일 수를 계산해주었기 때문에 -1을 해준다.
print(days_ans-1)
