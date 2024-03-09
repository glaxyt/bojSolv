# 16234번 인구 이동
from collections import deque
import sys

def bfs(x, y, visited):
    dxys=((1,0),(0,1),(-1,0),(0,-1))
    queue=deque([[x,y]])
    visited[y][x]=True
    total = grid[y][x]
    # 연합이 될 국가의 개수. len(trace)-1로 처리해도 됨,
    cnt = 0
    # 연합이 될 국가의 명단.
    trace=[[x,y]]
    while queue:
        cx,cy=queue.pop()
        for dx, dy in dxys:
            nx=cx+dx
            ny=cy+dy
            if 0<=nx<N and 0<=ny<N and visited[ny][nx]==False:
                if L<=abs(grid[ny][nx] - grid[cy][cx])<=R:
                    visited[ny][nx] = True
                    total += grid[ny][nx]
                    queue.appendleft([nx,ny])
                    trace.append([nx,ny])
                    cnt += 1
	# 인구 이동을 계산하는 수식
    modify = total//(cnt+1)
    for i,j in trace:
        grid[j][i] = modify
	# 연합을 이루는 국가가 존재했냐 안했냐에 따른 boolean 값 전달.
    if cnt == 0:
        return False
    else:
        return True

                    
# N은 주어진 영토의 변(정사각형입니다) L과 R은 연합이 될 수 있는 조건입니다.
N, L, R = map(int, input().split())
grid = []
for _ in range(N):
    grid.append(list(map
                     (int, sys.stdin.readline().split())))

# 연합을 만들 수 없을 때 까지 인구 이동이 이루어진 날들
ans= 0
while 1:
	# 하루마다 방문 기록을 초기화 해줍니다.
    visited = [[False]*N for _ in range(N)]
    # 연합이 이루어졌는지 확인하는 용도의 변수
    flag = False
    # 연합이 주축이 될 국가를 랜덤으로 브루트포스로 확인합니다.
    for i in range(N):
        for j in range(N):
        	# 연합이 될 수 있는 영토인지 확인해보지않은 국가를 고릅니다.
            if visited[i][j] == False:
           		# 연합이 이루어졌다면 flag를 True로 바꿉니다.
                if bfs(j, i, visited):
                    flag = True
    # 연합이 이루어졌기 때문에 하루 추가.
    if flag:
        ans += 1
    else:
        break

print(ans)
