# 1032번 명령 프롬프트
import sys
input = sys.stdin.readline
t = int(input())
word = []
for i in range(t):
    word.append(input().rstrip())
n = len(word[0])
ans = ''
for i in range(n):
    check = False
    for j in range(1, t):
        if word[0][i] != word[j][i]:
            check = True
            break
    if check:
        ans += '?'
    else:
        ans += word[0][i]
print(ans)
