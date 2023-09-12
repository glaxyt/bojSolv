# 2623번 음악프로그램
import sys
from collections import deque
n, m = map(int, sys.stdin.readline().split())
graph = [set() for _ in range(n+1)]
numOfEdges = [0] * (n+1)
ans = [0] * (n+1)
for _ in range(m):
    li = list(map(int, sys.stdin.readline().split()))
    num = li[0]
    # 1, 2, 3으로 입력이 들어온다면 3번은 1,2번이 준비되어야만 한다.
    for i in range(1, num+1):
        for j in range(1, i):
            graph[li[j]].add(li[i])

# 중복간선을 해결하기 위해 여기서 계산
for i in range(1, n+1):
    for j in graph[i]:
        numOfEdges[j] += 1
        
queue = deque([])

for i in range(1, n+1):
    if numOfEdges[i] == 0:
        queue.append(i)


cnt = 0

# 이미 탐색이 끝난 노드가 다시 불릴 수 있다.
while queue:
    cx = queue.popleft()
    cnt += 1
    ans[cnt] =cx
    for i in graph[cx]:
        numOfEdges[i] -= 1
        if numOfEdges[i] == 0:
            queue.append(i)

if cnt == n:
    for i in range(1, n+1):
        print(ans[i])
else:
    print(0)
