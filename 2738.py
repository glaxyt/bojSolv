# 2738번 행렬 덧셈
import sys
input = sys.stdin.readline

n, m  = map(int, input().split())
m1 = [list(map(int, input().split())) for _ in range(n)]
m2 = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    for j in range(m):
        print(m1[i][j] + m2[i][j], end=" ")
    print()
    
