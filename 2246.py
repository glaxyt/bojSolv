# 2246번 콘도 선정
import sys

n = int(input())
condoes = []
visited = [False] * n

def compare(cur_con):
    dist = cur_con[0]
    fee = cur_con[1]
    for j in range(n):
        if visited[j]:
            continue
        # 후보 x가 거리가 더 가까운데도 불구하고 비교하는 콘도의 가격이 저렴하거나 같은 경우
        if dist > condoes[j][0]:
            if fee >= condoes[j][1]:
                return 0
        # 후보 x가 가격이 더 저렴한데도 불구하고 비교하는 콘도의  거리가 짧거나 같은 경우
        elif fee > condoes[j][1]:
            if dist >= condoes[j][0]:
                return 0
    return 1


for _ in range(n):
    condo = list(map(int, sys.stdin.readline().rstrip().split()))
    condoes.append(condo)
    
ans = 0
for i in range(n):
    visited[i] = True
    ans += compare(condoes[i])
    visited[i] = False

print(ans)
