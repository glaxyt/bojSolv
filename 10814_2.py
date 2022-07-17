# 10814번 나이순 정렬
from sys import stdin
N = int(input())
s = []
for i in range(N):
    age, name = stdin.readline().rstrip().split()
    s.append((int(age), name))

# x는 리스트 s의 요소이며 x[0]은 age변수를 뜻한다.
s.sort(key=lambda x : x[0])	# key파라미터와 lambda를 이용해서 age변수를 기준으로 정렬하게 해준다.

for a, n in s:
    print(f"{a} {n}")
