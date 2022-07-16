# 17219번 비밀번호 찾기
import sys

n, m = map(int, input().split())
reposi = {}

for _ in range(n):
    site, password = sys.stdin.readline().rstrip().split()
    reposi[site] = password

for _ in range(m):
    find = sys.stdin.readline().rstrip()
    print(reposi[find])
