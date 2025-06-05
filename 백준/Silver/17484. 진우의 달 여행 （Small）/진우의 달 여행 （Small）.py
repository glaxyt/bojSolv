def solution():
    dys = (-1, 0, 1)
    n, m = map(int, input().split())
    grid = [list(map(int, input().split())) for _ in range(n)]
    dp = [[[float('inf') for _ in range(3)] for _ in range(m)] for _ in range(n)]

    for y in range(m):
        for d in range(3):
            dp[0][y][d] = grid[0][y]

    for cx in range(1, n):
        for cy in range(m):
            if cy > 0:
                dp[cx][cy][0] = min(dp[cx - 1][cy - 1][1], dp[cx - 1][cy - 1][2]) + grid[cx][cy]

            dp[cx][cy][1] = min(dp[cx - 1][cy][0], dp[cx - 1][cy][2]) + grid[cx][cy]

            if cy < m - 1:
                dp[cx][cy][2] = min(dp[cx - 1][cy + 1][0], dp[cx - 1][cy + 1][1]) + grid[cx][cy]

    answer = float('inf')
    for y in range(m):
        for d in range(3):
            answer = min(dp[n - 1][y][d], answer)

    print(answer)

solution()
