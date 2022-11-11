# 2010번 플러그
import sys
input = sys.stdin.readline

p = int(input())
total = 0
for _ in range(p):
    total += int(sys.stdin.readline())

print(total - (p-1))
