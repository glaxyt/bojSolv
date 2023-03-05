    # 16236번 아기상어3
    from collections import deque
    import sys

    # 아기상어는 상하좌우로 움직일 수 있습니다.
    dxys= [[0,-1],[-1,0],[0,1],[1,0]]

    # 격자의 크기와 아기상어와 물고기, 빈칸의 위치를 입력받습니다.
    N = int(input())
    grid = []
    for _ in range(N):
        grid.append(list(map(int, sys.stdin.readline().split())))

    # 아기상어의 초기 위치를 0으로 설정합니다. 추후에 이동할 때 상어가 지나가지 못하는 길이라 인식하는 것을 방지하기 위함입니다.
    for i in range(N):
        for j in range(N):
            if grid[i][j] == 9:
                shark_x = j
                shark_y = i
                grid[i][j] = 0

    # bfs를 이용하여 먹을 수 있는 물고기의 위치를 파악합니다.
    def bfs(s_x, s_y):
        queue = deque([])
        queue.append([s_x, s_y])
        # 방문 표시 겸 거리계산을 할 수 있게 해주는 2차원 리스트
        visited = [[0 for _ in range(N)] for _ in range(N)]
        visited[s_y][s_x] = 1
        # 먹을 수 있는 물고기까지의 거리 최솟값
        min_dis = sys.maxsize
        # 먹을 수 있는 물고기 후보군
        cand = []
        while queue:
            c_x, c_y = queue.popleft()
            for dx, dy in dxys:
                n_x = c_x + dx
                n_y = c_y + dy
                if 0 <= n_x < N and 0 <= n_y < N and grid[n_y][n_x] <= size and visited[n_y][n_x] == 0:
                    visited[n_y][n_x] = visited[c_y][c_x] + 1
                    queue.append([n_x, n_y])
                    if 0 < grid[n_y][n_x] < size and min_dis >= visited[n_y][n_x]:
                        min_dis = visited[n_y][n_x]
                        cand.append([min_dis-1, n_y, n_x])
        return sorted(cand)

    # 상어의 사이즈, 상어가 먹은 물고기 개수, 전체적으로 걸린 시간          
    size = 2
    eaten_fish = 0
    total_time = 0
                
    while 1:
        fish_loc = bfs(shark_x, shark_y)
        if fish_loc:
            # 정렬된 fish_loc에서 맨앞에 있는 리스트가 아기상어가 먹을 수 있는 물고기 중 가장 조건에 부합하는 물고기이다.
            time, shark_y, shark_x = fish_loc[0]
            grid[shark_y][shark_x] = 0
            total_time += time
            eaten_fish += 1
        else:
            break
        # 물고기를 아기상어의 사이즈만큼 먹었다면 사이즈가 1증가하며 먹은 물고기의 개수는 0으로 초기화된다.
        if eaten_fish == size:
            size += 1
            eaten_fish= 0
            
    print(total_time)
        
