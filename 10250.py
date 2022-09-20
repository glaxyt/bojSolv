# 10250번 ACM 호텔
import sys
k = int(input())

for _ in range(k):
    H, W, N = map(int, sys.stdin.readline().split())
    if N % H == 0:
        # yy는 항상 1 이상의 수가 나온다
        yy = N // H
        xx = H
    else:
        # yy에 1을 더해주는 이유는 호실의 범위가 1이상 99이하이기에 0이 나오진않게 보정해준다.
        yy = N // H + 1
        xx = N % H
    
    sys.stdout.write(f"{100 * xx + yy}\n")
