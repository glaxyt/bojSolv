# 1987번 알파벳
dxys = [[1,0],[-1,0],[0,1],[0,-1]]

def bfs():
    # 중복처리를 위해 set사용과 문자열을 이용하서 거쳐온 알파벳을 저장
    queue = set([(0, 0, grid[0][0])])
    visited = [[0] * m for _ in range(n)]
    # 최장 경로의 길이를 저장해줄 변수
    cnt = 0
    while queue:
        cx, cy, path = queue.pop()
        cnt = max(cnt, len(path))
        for dx, dy in dxys:
            nx = cx + dx
            ny = cy + dy
            if 0 <= nx < m and 0 <= ny < n:
                if grid[ny][nx] not in path:
                    n_path = path + grid[ny][nx] 
                    queue.add((nx, ny, n_path))
    return cnt
                

n, m = map(int, input().split())
grid = [list(input()) for _ in range(n)]
print(bfs())
