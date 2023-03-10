# 1049번 기타줄
import sys
N, M = map(int, sys.stdin.readline().split())
Min_pack = sys.maxsize
Min_single = sys.maxsize
for _ in range(M):
    package, single = map(int, sys.stdin.readline().split())
    if package < Min_pack:
        Min_pack = package
    if single < Min_single:
        Min_single = single

cand = [0,0,0]
leftover = N % 6
quotient = N // 6
if leftover == 0:
    cand[0] = Min_pack*(quotient)
else:
    cand[0] = Min_pack*(quotient+1)

cand[1] = quotient*Min_pack + leftover*Min_single
cand[2] = N * Min_single

print(min(cand))
    
