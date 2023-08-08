# 2252번 줄 세우기

import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n+1)]
numOfEdges = [0 for _ in range(n+1)]
queue = deque()
answer = []

for i in range(m):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append(b)
    numOfEdges[b] += 1

# 위상정렬 큐에 집어넣기 위해서 진입 간선이 0개인 노드를 고른다.
for i in range(1, n+1):
    if numOfEdges[i] == 0:
        queue.append(i)

while queue:
    c_n = queue.popleft()
    answer.append(c_n)
    # 진출 차선에 연결된 노드 추출.
    for i in graph[c_n]:
        numOfEdges[i] -= 1
        if numOfEdges[i] == 0:
            queue.append(i)

print(*answer)
