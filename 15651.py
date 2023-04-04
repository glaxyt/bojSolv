# 15651번 N과 M(3)
import sys
sys.setrecursionlimit(10000)
n, m = map(int, input().split())
arr = []

def find_num(cnt):
    if cnt == m:
        print(" ".join(list(map(str, arr))))
        return
    for i in range(1,n+1):
        arr.append(i)
        find_num(cnt+1)
        arr.pop()
        
find_num(0)
