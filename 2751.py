# 2751번 수 정렬하기 2
import sys
input = sys.stdin.readline
n = int(input())
s= [int(input()) for _ in range(n)]
s.sort()
for i in map(str, s):
    sys.stdout.write(f"{i}\n")
