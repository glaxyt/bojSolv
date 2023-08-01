# 18110번 solved.ac
import sys

def banollim(n):
    if n - int(n) >= 0.5:
        return int(n)+1
    return int(n)

t = int(input())

if t == 0:
    print(0)
else:
    cutline = t * 15/100
    cutline = banollim(cutline)
    estimations = [int(sys.stdin.readline()) for _ in range(t)]
    estimations.sort()
    print(banollim(sum(estimations[cutline:t-cutline]) / (t - cutline*2)))
        
