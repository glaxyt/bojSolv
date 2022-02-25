# 11651번 좌표 정렬하기 2
import sys
input = sys.stdin.readline

t = int(input())
li = []
for _ in range(t):
    li.append(list(map(int, input().split())))
    
li.sort(key = lambda x : (x[1], x[0]))
for a, b in li:
    print(a,b)
