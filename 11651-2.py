# 11651번 좌표 정렬하기 2
import sys
input = sys.stdin.readline

t = int(input())
li = []
for _ in range(t):
    x, y = map(int, input().split())
    li.append((y,x))
    
li.sort()

for a, b in li:
    print(b,a)
