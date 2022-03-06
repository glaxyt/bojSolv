# 1526번 가장 큰 금민수
import sys
input = sys.stdin.readline
n = int(input())
maximum = 0
for i in range(n+1):
    word = str(i)
    res = True
    for j in range(len(word)):
        if word[j] not in ['4', '7']:
            res = False
    if res:
        ans = i
print(ans)
