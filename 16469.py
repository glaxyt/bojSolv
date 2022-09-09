# 16469번 소년 점프
import sys
from collections import deque
input = sys.stdin.readline

# 좌표
dxs = [0, 0, 1, -1]
dys = [1, -1, 0, 0]

# row 행, col 열
row, col = map(int, input().rstrip().split())

# 미로 (1은 벽, 0은 이동가능 경로)
grid = [list(map(int, input().rstrip())) for _ in range(row)]

# bfs 함수 정의
def bfs(start_x, start_y):
    queue = deque([[start_x, start_y]])
    visited = [[0]*col for _ in range(row)]
    # 시작위치를 1로 설정해주었기 때문에 나중에 1을 빼주어야한다.
    visited[start_y][start_x] = 1
    while queue:
        cur_x, cur_y = queue.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = cur_x + dx, cur_y + dy
            if 0 <= nx < col and 0 <= ny < row and grid[ny][nx] == 0 and visited[ny][nx] == 0:
                visited[ny][nx] += (visited[cur_y][cur_x]+1)
                queue.append([nx, ny])
    return visited


# 스윙스, 넉살, 창모 위치를 덱에 넣어준 뒤 bfs를 사용해줍시다.
r1, c1 = map(int, input().rstrip().split())
r2, c2 = map(int, input().rstrip().split())
r3, c3 = map(int, input().rstrip().split())

# 스윙스, 넉살, 창모의 이동 경과 시간을 저장해주는 리스트
visited1 = bfs(c1-1, r1-1)
visited2 = bfs(c2-1, r2-1)
visited3 = bfs(c3-1, r3-1)

# 최소시간 계산
# ans1 => 최소 시간 ans2 => 최소 시간을 보유한 칸의 개수
ans1 = sys.maxsize
ans2 = 0
for y in range(row):
    for x in range(col):
        # 스윙스, 넉살, 창모가 가지못하는 경로는 계산하지않는다.
        if visited1[y][x] != 0 and visited2[y][x] != 0 and visited3[y][x] != 0:
            cur_time = max(visited1[y][x], visited2[y][x], visited3[y][x])
            if cur_time < ans1:
                ans1 = cur_time
                ans2 = 1
            elif ans1 == cur_time:
                ans2 += 1
                
# 존재하지않다면 -1 출력
if ans2 == 0:
    print(-1)
# 존재한다면 최소시간과 그러한 개수 출력
else:
    print(ans1-1)
    print(ans2)
