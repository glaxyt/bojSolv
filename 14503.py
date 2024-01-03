# 14503번 로봇 청소기
n, m = map(int, input().split())
c_x, c_y, dir = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
ans = 0
# dir  북 동 남 서
dxys = ((1,0), (0,-1), (-1,0), (0,1))

while 1:
    # 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
    if grid[c_x][c_y] == 0:
        grid[c_x][c_y] = 2
        ans += 1
    flag = 1

    for dx, dy in dxys:
        n_x = c_x + dx
        n_y = c_y + dy
        if 0 <= n_x < n and 0 <= n_y < m:
            # 현재 칸의 주변 4칸 청소안한 칸이 존재하는 경우
            if grid[n_x][n_y] == 0:
                flag = 0
                break
    # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,              
    if flag == 1:
        t_x = c_x + dxys[dir][0]
        t_y = c_y + dxys[dir][1]
        if 0 <= t_x < n and 0 <= t_y < m:
            # 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            # 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            if grid[t_x][t_y] == 1:
                break
            else:
                c_x = t_x
                c_y = t_y   

    # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
    else:
        # 반시계 방향으로 90도 회전한다.
        for _ in range(4):
            dir = (dir-1)%4
            t_x = c_x - dxys[dir][0]
            t_y = c_y - dxys[dir][1]
            if 0 <= t_x < n and 0 <= t_y < m:
                # 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                if grid[t_x][t_y] == 0:
                    c_x = t_x
                    c_y = t_y
                    break
                    
print(ans)
