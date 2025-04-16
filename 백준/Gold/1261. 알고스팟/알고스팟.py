## 첫째 줄에 미로의 크기를 나타내는 가로 크기 M, 세로 크기 N (1 ≤ N, M ≤ 100)이 주어진다.
## 다음 N개의 줄에는 미로의 상태를 나타내는 숫자 0과 1이 주어진다. 0은 빈 방을 의미하고, 1은 벽을 의미한다.
## 다익스트라 먼저 풀어보자 
import heapq

m, n = map(int, input().split())
graph = []
for _ in range(n):
  graph.append(list(map(int, list(input()))))

heap = [[0, 0, 0]]
dxs = (0, 0, 1, -1)
dys = (1, -1, 0, 0)

# 다익스트라에서 방문은 어떻게 처리하나요. 또 방문해도 되는지는 오직 cost로만 계산한다.
dist = [[10001 for _ in range(m)] for _ in range(n)]
dist[0][0] = 0
## 저장할 값 [x, y, c]
## 얼마나 돌아가나 이건 상관없다. 벽만 최소한으로 몇 개 깨야하는지가 중요해
## cost는 벽을 뚫은 개수
while heap:
  cost, cx, cy = heapq.heappop(heap)

  ## 벽을 더 많이 뚫고 온 도달했다면 더이상 이 경로는 무의미하니 처리 X
  if dist[cx][cy] < cost:
    continue

  for dx, dy in zip(dxs, dys):
    nx, ny = cx + dx, cy + dy
    if 0 <= nx < n and 0 <= ny < m:
      new_cost = cost
      if graph[nx][ny] == 1:
        new_cost += 1  

      if dist[nx][ny] > new_cost:
        dist[nx][ny] = new_cost
        heapq.heappush(heap, [new_cost, nx, ny])

print(dist[n-1][m-1])
