from collections import deque
dxys = ((0, 1), (0, -1), (1, 0), (-1, 0))

def solve():
    n = int(input())
    grid = []
    for _ in range(n):
        grid.append(input())
    visited = [[float("inf")] * n for _ in range(n)]
    queue = deque([(0,0)])
    visited[0][0] = 1

    while queue:
        x, y = queue.popleft()

        for dx, dy in dxys:
            nx = x + dx
            ny = y + dy
            if not validate_range(nx, ny, n):
                continue

            cost = visited[x][y]
            if grid[nx][ny] == "0":
                cost += 1

            if cost >= visited[nx][ny]:
                continue
            else:
                visited[nx][ny] = cost
                queue.append((nx, ny))

    print(visited[n-1][n-1] - 1)

def validate_range(x, y, n):
    if 0 > x or x >= n or 0 > y or y >= n:
        return False
    return True

solve()
