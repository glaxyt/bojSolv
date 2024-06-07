# 10810번 공 넣기
import sys

n, t = map(int, input().split())
basket = [0 for _ in range(n+1)]
for _ in range(t):
    a, b, c = map(int, sys.stdin.readline().split())
    for i in range(a, b+1):
        basket[i] = c

print(*basket[1:])
