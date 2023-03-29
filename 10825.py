# 10825번 국영수
import sys
input = sys.stdin.readline

t = int(input())
arr = []
for _ in range(t):
    n, a, b, c = input().rstrip().split()
    arr.append([n, int(a), int(b), int(c)])

arr.sort(key = lambda x : (-x[1],x[2],-x[3], x[0]) )

for i in range(t):
    print(arr[i][0])
