# 16928번 뱀과 사다리 게임
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
board = [0]*(101)
visited = [False]*(101)
for _ in range(n):
    a, b = map(int, input().split())
    board[a] = b
for _ in range(m):
    a, b = map(int, input().split())
    board[a] = b

def bfs():
    queue = deque([])
    queue.append([1,1])
    visited[1] = 1
    while queue:
        cnt, c = queue.popleft()
        for i in range(1,7):
            n_c = c + i
            if 0 <= n_c < 101 and visited[n_c] == False:
                if board[n_c] != 0:
                    visited[n_c] = cnt +1
                    queue.append([cnt+1, board[n_c]])
                    if visited[board[n_c]] == False:
                        visited[board[n_c]] = cnt + 1
                else:
                    visited[n_c] = cnt + 1
                    queue.append([cnt+1, n_c])
bfs()
print(visited[100]-1)
    
    
