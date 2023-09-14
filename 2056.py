# 2056번 작업
import sys
from collections import deque

n = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)]
cost  = [0 for _ in range(n+1)]
numOfEdges = [0 for _ in range(n+1)]
for i in range(1, n+1):
    info = list(map(int, sys.stdin.readline().split()))
    cost[i] = info[0]
    nums = info[1]
    numOfEdges[i] = nums
    for j in range(2, nums+2):
        graph[info[j]].append(i)
        
queue = deque([])

dp = [0 for _ in range(n+1)]

for i in range(1, n+1):
    if numOfEdges[i] == 0:
        queue.append(i)
        dp[i] = cost[i]

while queue:
    c = queue.popleft()
    for i in graph[c]:
        dp[i] = max(dp[i], dp[c] + cost[i])
        numOfEdges[i] -= 1
        if numOfEdges[i] == 0:
            queue.append(i)

print(max(dp))