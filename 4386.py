# 4386번 별자리 만들기
import sys
v = int(input())
star_loc = [[0,0]]
edges = []
for _ in range(v):
    x, y = map(float, sys.stdin.readline().split())
    star_loc.append([x,y])

for i in range(1, v):
    for j in range(i+1, v+1):
        cost = ((star_loc[i][0] - star_loc[j][0])**2 + (star_loc[i][1] - star_loc[j][1])**2)**0.5
        edges.append([cost, i, j])

edges.sort()
parents = [i for i in range(v+1)]

def find_parent(x):
    if parents[x] != x:
        parents[x] = find_parent(parents[x])
    return parents[x]

def union(n1, n2):
    n1 = find_parent(n1)
    n2 = find_parent(n2)
    if n1 < n2:
        parents[n2] = n1
    else:
        parents[n1] = n2
ans = 0
e = len(edges)
for i in range(e):
    w, a, b = edges[i] 
    if find_parent(a) != find_parent(b):
        union(a, b)
        ans += w
print(round(ans,2))
