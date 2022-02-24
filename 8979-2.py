import sys
input = sys.stdin.readline
n, k = map(int, input().split())
score = [list(map(int, input().split())) for _ in range(n)]
score.sort(key = lambda x : (x[1], x[2], x[3]), reverse = True)

for i, args in enumerate(score, 1):
    if args[0] == k:
        rank = i

target = score[rank-1][1:]
for idx,g,s,b in score:
    if idx == k:
        print(rank)
        break
    elif [g, s, b] == target:
        rank -= 1
