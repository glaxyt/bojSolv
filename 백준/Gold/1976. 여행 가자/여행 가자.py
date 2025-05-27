def solution():
  n = int(input())
  m = int(input())

  global parent
  parent = [i for i in range(n)]

  for i in range(n):
    row = list(map(int, input().split()))
    for j in range(n):
        if row[j] == 1:
            union(i, j)

  plan = list(map(int, input().split()))
  root = find_parent(plan[0] - 1)

  for i in range(m):
    if find_parent(plan[i] - 1) != root:
      print("NO")
      return

  print("YES")
  return

def union(a, b):
    a_root = find_parent(a)
    b_root = find_parent(b)
    if a_root != b_root:
        parent[b_root] = a_root

def find_parent(x):
  if x != parent[x]:
    parent[x] = find_parent(parent[x])
  return parent[x]

solution()