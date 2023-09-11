# 1516번 게임개발
import sys
from collections import deque

n = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)]
numOfEdges = [0 for _ in range(n+1)]
cost = [0 for _ in range(n+1)]
for i in range(1, n+1):
    info = list(map(int ,sys.stdin.readline().rstrip("-1\n").split()))
    # 건물을 짓는데 걸리는 시간
    cost[i] = info[0]
    # 건물을 짓기위해 선행으로 지어져야하는 건물번호 저장
    for j in info[1:]:
        graph[j].append(i)
        numOfEdges[i] += 1
    
queue = deque([])

dp = [0 for _ in range(n+1)]

for i in range(1, n+1):
    if numOfEdges[i] == 0:
        queue.append(i)
        dp[i] = cost[i]

while queue:
    c_n = queue.popleft()
    for i in graph[c_n]:
        dp[i] = max(dp[i], dp[c_n] + cost[i])
        numOfEdges[i] -= 1
        if numOfEdges[i] == 0:
            queue.append(i)

print("\n".join(list(map(str, dp[1:]))))
