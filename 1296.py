# 1296번 팀 이름 정하기
import sys

yeondu = input()
t = int(input())
teams = [0] * t
for i in range(t):
    teams[i] = sys.stdin.readline().rstrip()

ans = ""
teams.sort()
maximum = -1

for i in range(t):
    word = yeondu + teams[i]
    L = word.count('L')
    O = word.count('O')
    V = word.count('V')
    E = word.count('E')
    total = ((L+O) * (L+V) * (L+E) * (O+V) * (O+E) * (V+E)) % 100
    if total > maximum:
        ans = teams[i]
        maximum = total

print(ans)
