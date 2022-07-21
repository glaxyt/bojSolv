# 16395 파스칼의 삼각형
n, m = map(int, input().split())

s = [[1 for _ in range(i)] for i in range(1, 31)]

for i in range(2, 30):
    for j in range(1, i):
        s[i][j] = s[i-1][j-1] + s[i-1][j]
        
print(s[n-1][m-1])
