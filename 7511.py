# 7511번 소셜 네트워킹 어플리케이션
import sys
input = sys.stdin.readline

scene_num = 1
def find_parent(j):
    if parents[j] != j:
        parents[j] = find_parent(parents[j])
    return parents[j]

def union(p1, p2):
    p1 = find_parent(p1)
    p2 = find_parent(p2)
    if p1 > p2:
        parents[p1] = p2
    else:
        parents[p2] = p1

t = int(input())
for _ in range(t):
    n = int(input())
    r1 = int(input())
    parents = [i for i in range(n+1)]
    
    for _ in range(r1):
        a, b = map(int, input().split())
        if parents[a] != parents[b]:
            union(a, b)

    print(f"Scenario {scene_num}:")
    r2 = int(input())
    
    for _ in range(r2):
        a, b = map(int, input().split())
        if find_parent(a) == find_parent(b):
            print(1)
        else:
            print(0)

    print()
    scene_num += 1
