# 17836번 공주님을 구해라!
# 0은 빈공간 1은 벽 2는 그람을 의미한다.
import sys
from collections import deque
input = sys.stdin.readline
n, m, t = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

dxys = ((0,1),(0,-1),(1,0),(-1,0))

def bfs():
    queue = deque([])
    queue.append([0,0])
    visited[0][0] = 1
    gram = []
    had_gram = 10001
    had_no_gram = 10001
    while queue:
        c_x, c_y = queue.popleft()
        for dx, dy in dxys:
            n_x = c_x + dx
            n_y = c_y + dy
            if 0 <= n_x < m and 0 <= n_y < n and visited[n_y][n_x] == 0 and grid[n_y][n_x] != 1:
                visited[n_y][n_x] = visited[c_y][c_x] + 1
                queue.append([n_x, n_y])
                if grid[n_y][n_x] == 2:
                    gram.append([n_x, n_y, visited[n_y][n_x]])
    if gram:
        gram_x, gram_y, cost = gram[0]
        had_gram = (n-(gram_y+1)) + (m-(gram_x+1)) + cost - 1
    if visited[n-1][m-1]:
        had_no_gram = visited[n-1][m-1] - 1
    return min(had_gram, had_no_gram)

spend_time = bfs()
# 제한 시간안에 들어올 경우 계산된 시간을 출력해줍니다.
if t >= spend_time:
    print(spend_time)
else:
    print("Fail")
