# 1181번 단어정렬
import sys
n = int(input())
s = set()
for _ in range(n):
    s.add(sys.stdin.readline())
s = list(s)
s.sort()
s.sort(key=len)
print(''.join(s))
