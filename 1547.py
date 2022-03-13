# 1547번 공
import sys
input = sys.stdin.readline
n = int(input())
li = [0, 1, 2, 3]
for _ in range(n):
    a, b = map(int, input().split())
    temp = li.index(a)
    li[li.index(b)] = a
    li[temp] = b

print(li[1])
