# 1764번 듣보잡
import sys
n, m = map(int, input().split())
a = set()
b = set()
for _ in range(n):
    a.add(sys.stdin.readline().rstrip())
for _ in range(m):
    b.add(sys.stdin.readline().rstrip())

ans = sorted(a&b)   # 교집합 성질 사용.

print(len(ans)) # 같은 이름의 요소의 개수
for i in ans:   # 교집합에 해당하는 요소 출력
    print(i)
