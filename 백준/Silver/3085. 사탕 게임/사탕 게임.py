from itertools import permutations
answer = 1
N = int(input())
grid = [list(input()) for _ in range(N)]
dxys = ((0,1), (0,-1), (1,0), (-1,0))

def backtracking(N, grid):
    global answer
    
    row_searching(N, grid)
    col_searching(N, grid)
    
    for cx in range(N):
        for cy in range(N):
            for dx, dy in dxys:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < N and 0 <= ny < N and grid[cx][cy] != grid[nx][ny]:
                    tmp = grid[nx][ny]
                    grid[nx][ny] = grid[cx][cy]
                    grid[cx][cy] = tmp

                    row_searching(N, grid)
                    col_searching(N, grid)

                    grid[cx][cy] = grid[nx][ny]
                    grid[nx][ny] = tmp
    print(answer)
                    


def row_searching(N, grid):
    global answer
    
    for i in range(N):
        px = ""
        cnt = 1
        for j in range(N):
            cx = grid[i][j]
            if not px:
                px = cx
                continue
            if px == cx:
                cnt += 1
            else:
                answer = max(answer, cnt)
                cnt = 1
                px = cx

        answer = max(answer, cnt)

    return answer

def col_searching(N, grid):
    global answer 
    
    for i in range(N):
        px = ""
        cnt = 1
        for j in range(N):
            cx = grid[j][i]
            if not px:
                px = cx
                continue
            if px == cx:
                cnt += 1
            else:
                answer = max(answer, cnt)
                cnt = 1
                px = cx
                
        answer = max(answer, cnt)

    return answer

backtracking(N, grid)