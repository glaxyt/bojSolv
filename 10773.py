# 10773번 제로
import sys
n = int(input())
stack = []
for i in range(n):
    m = int(sys.stdin.readline())
    if m == 0:
        stack.pop()
    else:
        stack.append(m)
print(sum(stack))
