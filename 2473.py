# 2473번 세 용액
# 투포인터와 완전탐색 사용.
import sys
n = int(input())
liquid = list(map(int, input().split()))
# 정렬이 안되어있기에 정렬 우선.
liquid.sort()
min_sumOfLiquid_2 = sys.maxsize
ans = []

if n == 3:
        print(*liquid)
else:
    for i in range(n-2):
        tmp = liquid.pop()
        start = 0
        end = len(liquid)-1
        
        while start < end:
            sumOfLiquid_2 = liquid[start] + liquid[end] + tmp

            if abs(sumOfLiquid_2) < min_sumOfLiquid_2:
                min_sumOfLiquid_2 = abs(sumOfLiquid_2)
                ans = [liquid[start], liquid[end], tmp]
                
            if sumOfLiquid_2 > 0:
                end -= 1
            else:
                start += 1

            if sumOfLiquid_2 == 0:
                break
                
        if sumOfLiquid_2 == 0:
            break
            
    print(*ans)
