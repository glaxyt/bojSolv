import sys
sys.setrecursionlimit(10**8)

def solve():
    n, m, r = map(int, input().split())
    graph = [[] for _ in range(n + 1)]
    visited = [0 for _ in range(n + 1)]
    for _ in range(m):
        a, b = map(int, sys.stdin.readline().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(1, n + 1):
        graph[i].sort(reverse=True)

    def dfs(cur_node):
        nonlocal cnt
        visited[cur_node] = cnt

        for next_node in graph[cur_node]:
            if not visited[next_node]:
                cnt += 1
                dfs(next_node)
    cnt = 1
    dfs(r)
    for idx in range(1, n + 1):
        print(visited[idx])

solve()