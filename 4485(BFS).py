# 4485번 녹색 옷 입은 애가 젤다지?
import sys
from collections import deque

dxs = [1, -1, 0, 0]
dxy = [0, 0, 1, -1]

def bfs():
    queue = deque([[0,0]])
    visited = [[sys.maxsize] * n for _ in range(n)]
    visited[0][0] = grid[0][0]
    while queue:
        curr_x, curr_y = queue.popleft()
        for dx, dy in zip(dxs, dxy):
            new_x , new_y = curr_x + dx, curr_y + dy
            if 0 <= new_x < n and 0 <= new_y < n:
                if visited[new_y][new_x] > visited[curr_y][curr_x] + grid[new_y][new_x]:
                    visited[new_y][new_x] = visited[curr_y][curr_x] + grid[new_y][new_x]
                    queue.append((new_x, new_y))
    return visited

i = 1
while 1:
    # 동굴 크기
    n = int(input())

    # 동굴 크기가 0이면 종료
    if n == 0:
        break

    # 동굴 grid
    grid = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
    print(f'Problem {i}: {bfs()[-1][-1]}')
    i += 1
    
        
    
