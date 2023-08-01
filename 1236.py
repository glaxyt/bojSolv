# 1236번 성 지키기
def check(li, length):
    cnt = 0
    for i in range(length):
        if li[i] == False:
            cnt += 1 
    return cnt

n, m = map(int, input().split())
horizon = [False] * n
vertical = [False] * m
grid = [list(input()) for _ in range(n)]
ans = 0

for i in range(n):
    for j in range(m):
        if grid[i][j] == "X":
            horizon[i] = True
            vertical[j] = True

ans = max(check(horizon, n), check(vertical, m))
print(ans)
        
