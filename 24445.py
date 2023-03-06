# 24445번 알고리즘 수업
from collections import deque
import sys

# 정점의 개수: N 간선의 수: M 시작정점: R
N, M, R = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    d1, d2 = map(int, sys.stdin.readline().split())
    graph[d1].append(d2)
    graph[d2].append(d1)

visited = [False for _ in range(N+1)]    
queue = deque([])
ans = [0 for _ in range(N+1)]

def bfs():
    queue.append(R)
    visited[R] = True
    cnt = 1
    ans[R] = cnt
    while queue:
        s = queue.popleft()
        for i in sorted(graph[s], reverse = True):
            if visited[i] == False:
                queue.append(i)
                visited[i] = True
                cnt += 1
                ans[i] = cnt

bfs()                
for i in range(1,N+1):
    print(ans[i])
