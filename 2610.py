# 2610 회의준비 
# 서로 묶여있는 위원회 찾기 = BFS, 최단경로 구하기 =  플로이드 와샬
import heapq
from collections import deque
import sys
INF = sys.maxsize
input = sys.stdin.readline

def bfs(v):
    queue = deque([v])
    visited[v] = True
    node_li = [v]
    while queue:
        now = queue.popleft()
        for i in range(1, n+1):
            if graph[now][i] != INF and not visited[i]:
                queue.append(i)
                visited[i] = True
                node_li.append(i)
    return node_li

n = int(input())
m = int(input())
groupNum = 0
graph = [[INF]*(n+1) for _ in range(n+1)]
visited = [False] * (n+1)

# 플로이드 와샬
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

for a in range(1, n+1):
    for b in range(1, n+1):
        if a == b:
            graph[a][b] = 0

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# BFS를 이용한 위원회의 개수
nums = []
for i in range(1, n+1):
    if visited[i] == False:
        visit_li = bfs(i)
        groupNum += 1
        Maximum = INF
        for k in visit_li:
            # 한 노드에서 최댓값을 찾는 코드.
            Maximum_k = -1
            for j in visit_li:
                Maximum_k = max(graph[k][j], Maximum_k)
            # 최댓값들 중 가장 작은 최댓값을 구하는 코드.
            if Maximum_k < Maximum:
                Maximum = Maximum_k
                ans = k
        nums.append(ans)
# 오름차순 정렬
nums.sort()
print(groupNum)
for i in nums:
    print(i)
