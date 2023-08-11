# 20040번 사이클 게임
# 사이클이 생기는지에 대한 확인을 위해 분리집합을 사용할 것이다. bfs는 시간소모가 너무크다.
import sys

def find_parent(x):
    if x != parent[x]:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union(a, b):
    a = find_parent(a)
    b = find_parent(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n, m = map(int, sys.stdin.readline().split())
parent = [i for i in range(n)]

ans = 0
for i in range(m):
    x, y = map(int, sys.stdin.readline().split())
    # 부모가 같다면 사이클 구성한다.
    if find_parent(x) != find_parent(y):
        union(x, y)
    else:
        ans = i + 1
        break
print(ans)
