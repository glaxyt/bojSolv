def solve():
    n, l = map(int, input().split())
    grid = [list(map(int, input().split())) for _ in range(n)]

    def can_pass(line):
        used = [False] * n  # 경사로 설치 여부
        i = 0

        while i < n - 1:
            if line[i] == line[i + 1]:
                i += 1
                continue

            # 높이 차이가 1이 아니면 불가능
            if abs(line[i] - line[i + 1]) != 1:
                return False

            # 오르막길 (낮은곳 → 높은곳)
            if line[i] < line[i + 1]:
                # 뒤로 l만큼 같은 높이이고 경사로가 없어야 함
                if i + 1 - l < 0:
                    return False

                for j in range(i + 1 - l, i + 1):
                    if line[j] != line[i] or used[j]:
                        return False
                    used[j] = True

                i += 1

            # 내리막길 (높은곳 → 낮은곳)
            else:
                # 앞으로 l만큼 같은 높이이고 경사로가 없어야 함
                if i + 1 + l > n:
                    return False

                for j in range(i + 1, i + 1 + l):
                    if line[j] != line[i + 1] or used[j]:
                        return False
                    used[j] = True

                i += l

        return True

    answer = 0

    # 가로 길 체크
    for i in range(n):
        if can_pass(grid[i]):
            answer += 1

    # 세로 길 체크
    for j in range(n):
        column = [grid[i][j] for i in range(n)]
        if can_pass(column):
            answer += 1

    print(answer)


solve()