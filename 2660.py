# 2660번 회장뽑기
import sys
from collections import deque

input = sys.stdin.readline

INF = int(1e9)

n = int(input())
graph = [[] for i in range(n+1)]
while 1:
    a, b = map(int, input().split())
    if a == -1:
        break
    graph[a].append(b)
    graph[b].append(a)

def bfs(s):
    queue = deque([])
    queue.append([s, 0])
    visited = [False] * (n+1)
    visited[s] = True
    score = -1
    while queue:
        cur_p, cur_score = queue.popleft()
        for f in graph[cur_p]:
            if visited[f] == False:
                visited[f] = True
                score = max(score, cur_score+1)
                queue.append([f, cur_score+1])
    for i in range(1,n+1):
        if not visited[i]:
            return INF
    return score

cand = []
min_score = INF
for j in range(1, n+1):
    temp = bfs(j)
    if temp == INF:
        continue
    if temp < min_score:
        cand = []
        cand.append(j)
        min_score = temp
    elif temp == min_score:
        cand.append(j)

print(min_score, len(cand))
print(" ".join(list(map(str, sorted(cand)))))
