# 14425 문자열 집합
import sys
n, m = map(int,input().split())
ans = 0

s  = set([sys.stdin.readline() for i in range(n) ])

for _ in range(m):
    word = sys.stdin.readline()
    if word  in s:
            ans += 1
    
print(ans)
