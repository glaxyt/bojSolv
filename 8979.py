# 8979번 올림픽
import sys
input = sys.stdin.readline
n, k = map(int, input().split())
score = [list(map(int, input().split())) for _ in range(n)]
score.sort(key = lambda x : (x[1], x[2], x[3]), reverse = True)

for i in range(n):
    if score[i][0] == k:
        target = i
        break

for idx,nation in enumerate(score, 1):
    if score[target][1:] == nation[1:]:
        print(idx)
        break
