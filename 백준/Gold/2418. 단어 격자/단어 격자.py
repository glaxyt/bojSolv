h, w, l = map(int, input().split())
grid = [list(input()) for _ in range(h)]
word = list(input())

dxs = (0, 0, 1, -1, 1, -1, 1, -1)
dys = (1, -1, 0, 0, 1, -1, -1, 1)

# dp[x][y][idx] = x,y에서 idx번째 문자부터 시작할 때 가능한 경로 수
dp = [[[-1 for _ in range(l)] for _ in range(w)] for _ in range(h)]

def dfs(x, y, idx):
    if not (0 <= x < h and 0 <= y < w):
        return 0

    if grid[x][y] != word[idx]:
        return 0

    if idx == l - 1:
        return 1

    if dp[x][y][idx] != -1:
        return dp[x][y][idx]

    count = 0
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        count += dfs(nx, ny, idx + 1)

    dp[x][y][idx] = count
    return count

answer = 0
for i in range(h):
    for j in range(w):
        answer += dfs(i, j, 0)

print(answer)
