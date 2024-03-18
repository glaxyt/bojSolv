# 1715번 카드 정렬하기
from heapq import heappop, heappush
import sys

queue = []
n = int(input())
for _ in range(n):
    heappush(queue, int(sys.stdin.readline()))

ans = 0

while len(queue) > 1:
    minimum_first = heappop(queue)
    minimum_second = heappop(queue)
    new_num = minimum_first + minimum_second
    ans += new_num

    heappush(queue, new_num)

print(ans)
