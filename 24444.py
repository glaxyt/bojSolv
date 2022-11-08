# 24444번 알고리즘 수업 - 너비 우선 탐색 1
import sys
from collections import deque

n, m, r = map(int, input().split())
graph  = [ [] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    v1, v2 = map(int, sys.stdin.readline().rstrip().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

ans = {}
for i in range(1, n+1):
    ans[i] = 0

def bfs(s_v):
    queue = deque([s_v])
    visited[s_v] = True
    ans[s_v] = 1
    cnt = 2
    while queue:
        v = queue.popleft()
        for w in sorted(graph[v]):
            if visited[w] == False:
                ans[w] = cnt
                cnt += 1
                visited[w] = True
                queue.append(w)

bfs(r)

for j in range(1, n+1):
    print(ans[j])
