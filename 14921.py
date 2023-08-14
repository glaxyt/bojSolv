# 14921번 용액 합성하기
# 투포인터 사용.
import sys
n = int(input())
liquid = list(map(int, input().split()))
min_sumOfLiquid = sys.maxsize
ans = 0

if n == 2:
        print(sum(liquid))
else:
    start, end = 0, n-1
    while start < end:
            sumOfLiquid = liquid[start] + liquid[end]

            if abs(sumOfLiquid) < min_sumOfLiquid:
                min_sumOfLiquid = abs(sumOfLiquid)
                ans = sumOfLiquid
                
            if sumOfLiquid > 0:
                end -= 1
            else:
                start += 1

            if sumOfLiquid == 0:
                ans = 0
                break
            
    print(ans)
