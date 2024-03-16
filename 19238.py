# 19238번 스타트 택시
import sys
from collections import deque
dxys = ((0,-1),(-1,0),(1,0),(0,1))

N, M, fuel = map(int, sys.stdin.readline().split())
# 벽은 1 이동가능한 통로는 0
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
driver_x, driver_y = map(int, input().split())
driver_x -= 1
driver_y -= 1
way = [[],[]]
for i in range(2, M+2):
    start_x, start_y, finish_x, finish_y = map(int, input().split())
    # 시작 지점과 도착 지점을 구별하작는 마킹이 필요하다.
    grid[start_x-1][start_y-1] = i
    # 도착 지점을 리스트에 저장
    way.append([finish_x-1, finish_y-1])
    
# 택시의 위치 -> 고객의 위치
def bfs():
    if grid[driver_x][driver_y] not in (0,1):
        return [0, driver_x, driver_y]
    # cost, 행 위치, 열 위치
    queue = deque([[0, driver_x, driver_y]])
    visited = [[False]*N for _ in range(N)]
    visited[driver_x][driver_y] = True
    # 최단거리 설정
    min_cost = sys.maxsize
    target = []
    while queue:
        cost, cx, cy = queue.pop()
        for dx, dy in dxys:
            nx = cx + dx
            ny = cy + dy
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == False:
                if grid[nx][ny] != 1:
                    queue.appendleft([cost+1, nx, ny])
                    visited[nx][ny] = True
                    if grid[nx][ny] == 0:
                        continue
                    else:
                    # 만일 최단거리보다 긴 거리의 고객을 찾았다면 BFS탐색을 중지한다.
                    # 더 짧은 거리의 고객을 모두 찾았기에 더 긴 거리의 고객이 탐색되는 것이다.
                    # 정렬해서 최소 행, 최소 열의 고객의 위치를 찾아준다.
                        if cost > min_cost:
                            return min(target)
                        min_cost = cost
                        target.append([cost+1, nx, ny])
                        
    # 찾은 모든 고객이 동일한 거리에 존재한다면, 정렬을 통해서 최소 행, 최소 열의 고객의 위치를 찾아준다. 
    if target:
        return min(target)
    else:
        return [-1,0,0]
    
# 고객의 위치 -> 고객의 목적지
def bfsToTarget(sx, sy, fxy):
    grid[sx][sy] = 0
    visited = [[False] * N for _ in range(N)]
    visited[sx][sy] = 1
    queue = deque([[sx, sy]])
    while queue:
        cx, cy = queue.pop()
        if [cx, cy] == fxy:
            return [visited[fxy[0]][fxy[1]] - 1, cx, cy]
        for dx, dy in dxys:
            nx = cx + dx
            ny = cy + dy
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == False:
                if grid[nx][ny] != 1:
                    visited[nx][ny] = visited[cx][cy] + 1
                    queue.appendleft([nx,ny])
            
    return [-1,0,0]

for _ in range(M):
    cost_to_customer, driver_x ,driver_y = bfs()
    # 고객을 태우러 갈 연료가 부족하다면 -1 출력
    if cost_to_customer == -1:
        fuel = -1
        break
    cost_fuel, driver_x, driver_y = bfsToTarget(driver_x, driver_y, way[grid[driver_x][driver_y]])
    # 손님을 이동시킬 수 없을 경우.
    if cost_fuel == -1 or cost_fuel + cost_to_customer > fuel:
        fuel = -1
        break
    
    # 손님을 이동시킬 수 있다면 고객의 위치 -> 고객의 목적지까지의 소모 연료를 두배해서 충전해준다.
    else:
        fuel -= (cost_fuel + cost_to_customer)
        fuel += (cost_fuel*2)

print(fuel)
