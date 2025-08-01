import math

def solution():
    n = int(input())
    nums = list(map(int, input().split()))
    underNum = math.lcm(*nums)
    upperNum = 0
    for i in range(n):
        upperNum += underNum // nums[i]
    div = math.gcd(upperNum, underNum)
    print(underNum // div, "/", upperNum // div, sep = "")

solution()
