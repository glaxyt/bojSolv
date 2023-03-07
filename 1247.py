# 1247번 부호
import sys

for _  in range(3):
    t = int(input())
    total = 0
    for _ in range(t):
        total += int(sys.stdin.readline())
    if total == 0:
        print(0)
    elif total > 0:
        print("+")
    else:
        print("-")
        
