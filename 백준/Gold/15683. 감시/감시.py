from copy import deepcopy

N, M = map(int, input().split())
office = [list(map(int, input().split())) for _ in range(N)]

# 북 동 남 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 각 CCTV 타입별 가능한 감시 방향 조합
cctv_directions = {
    1: [[0], [1], [2], [3]],                     # 한 방향
    2: [[0, 2], [1, 3]],                         # 양방향 (상하 / 좌우)
    3: [[0, 1], [1, 2], [2, 3], [3, 0]],         # ㄱ자 방향
    4: [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],  # 세 방향
    5: [[0, 1, 2, 3]]                            # 전방향
}

answer = []

def solution():
    cctv = []
    for x in range(N):
        for y in range(M):
            if office[x][y] in (1, 2, 3, 4, 5):
                cctv.append((x, y, office[x][y]))

    backtracking(office, cctv, 0)
    print(min(answer))

def backtracking(office, cctv, idx):
    if idx == len(cctv):
        count = sum(row.count(0) for row in office)
        answer.append(count)
        return

    x, y, type = cctv[idx]
    for dirs in cctv_directions[type]:
        copied = deepcopy(office)
        for d in dirs:
            watch(copied, x, y, d)
        backtracking(copied, cctv, idx + 1)

def watch(office, x, y, d):
    nx, ny = x + dx[d], y + dy[d]
    while 0 <= nx < N and 0 <= ny < M and office[nx][ny] != 6:
        if office[nx][ny] == 0:
            office[nx][ny] = -1
        nx += dx[d]
        ny += dy[d]

solution()
