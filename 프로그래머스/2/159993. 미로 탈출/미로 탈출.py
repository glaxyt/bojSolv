from collections import deque

def solution(maps):
    answer = 0
    row = len(maps)
    col = len(maps[0])
    que = deque([])
    visited = [[0 for _ in range(col)] for _ in range(row)]
    dxys = ((0,1), (0,-1), (1,0), (-1,0))
    
    def can_go(x, y):
        return 0 <= x < row and 0 <= y < col
    
        ## 레버 찾기
    def bfs(x, y, target):
        visited = [[0 for _ in range(col)] for _ in range(row)]
        visited[x][y] = 1
        que = deque([[x, y]])
        
        while que:
            cx, cy = que.popleft()

            if maps[cx][cy] == target:
                return visited[cx][cy] - 1
                

            for dx, dy in dxys:
                nx, ny = cx + dx, cy + dy
                if can_go(nx, ny) and maps[nx][ny] != 'X' and not visited[nx][ny]:
                    visited[nx][ny] = visited[cx][cy] + 1
                    que.append([nx, ny])
                    
        return -1
    
    sx, sy = 0, 0
    lx, ly = 0, 0
    
    for i in range(row):
        for j in range(col):
            if maps[i][j] == 'S':
                sx, sy = i, j
            elif maps[i][j] == 'L':
                lx, ly = i, j
    
    ## 레버를 못 찾음
    to_lever = bfs(sx, sy, 'L')
    if to_lever == -1:
        return -1
    
    to_exit = bfs(lx, ly, 'E')
    if to_exit == -1:
        return -1
    print(to_lever, to_exit)
    answer = to_lever + to_exit
    return answer