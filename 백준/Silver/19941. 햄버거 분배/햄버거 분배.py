def solution():
    n, k = map(int, input().split())
    grid = list(input())
    visited = [False] * n
    answer = 0
    idx = 0
    while idx < n:
        if grid[idx] == "H":
            for i in range(idx - k, idx + k + 1):
                if 0 > i or i >= n:
                    continue
                if grid[i] == "P" and not visited[i]:
                    visited[i] = True
                    answer += 1
                    break
        idx += 1

    print(answer)

solution()