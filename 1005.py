# 1005번 ACMcraft
import sys
from collections import deque

t = int(input())
for _ in range(t):
    n, k = map(int, sys.stdin.readline().split())
    cost = list(map(int, sys.stdin.readline().split()))
    graph = [[] for _ in range(n)]
    numOfEdges = [0 for _ in range(n)]
    for _ in range(k):
        a, b = map(int, sys.stdin.readline().split())
        graph[a-1].append(b-1)
        numOfEdges[b-1] += 1
        
    fin_node = int(sys.stdin.readline())
    queue = deque([])

    dp = [0 for _ in range(n)]
    
    for i in range(n):
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

    print(dp[fin_node-1])
