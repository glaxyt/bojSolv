# 7568번 덩치
import sys

n = int(input())
people = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# 덩치의 순위를 저장해줄 리스트
ans = []

for k in range(n):
    cnt = 0
    for i in range(n):
        # 자기 자신을 비교할 필요는 없으니 continue를 해준다.
        if i == k:
            continue
        # 몸무게와 키를 비교했을 때 더 클 경우.
        if people[k][0] < people[i][0] and people[k][1] < people[i][1]:
            cnt += 1
    ans.append(cnt+1)

print(" ".join(map(str, ans)))
            
