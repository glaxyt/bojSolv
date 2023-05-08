# 7785번 회사에 있는 사람
import sys

n = int(input())
li = set()
for _ in range(n):
    name, stat = input().rstrip().split()
    if stat == "enter":
        li.add(name)
    else:
        li.discard(name)

print("\n".join(sorted(list(li), reverse=True)))
