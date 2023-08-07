# 1002번 터렛
import sys
t = int(input())
for _ in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, sys.stdin.readline().split())
    # 두 원의 중심 사이의 거리
    mid_length = ((x2-x1)**2 + (y2-y1)**2)**(1/2)
    # 두 원의 중점이 같은 위치일 경우.
    if mid_length == 0:
        if r1 == r2:
            # 겹치는 점이 무한대 존재
            print(-1)
        else:
            print(0)
    # 두 원의 중점이 다른 위치일 경우.
    else:
        # 겹치는 점이 없을 경우. 두 원이 멀어서 닿지않는경우, 한 원이 다른 원을 포괄하는 경우.
        if r1+r2 < mid_length or r1 > mid_length+r2 or r2 > mid_length+r1:
            print(0)
        # 두 원이 겹치는 점이 1개일 경우.
        elif r1+r2 == mid_length or r1 == mid_length+r2 or r2 == mid_length+r1:
            print(1)      
        # 두 원이 겹치는 점이 2개일 경우.
        else:
            print(2)
