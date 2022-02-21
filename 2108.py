# 2108번 통계학
import sys
from collections import Counter
input = sys.stdin.readline

N = int(input())
numbers=[]
for _ in range(N):
    num = int(input())
    numbers.append(num)
numbers.sort()

print(round(sum(numbers) / N))
print(numbers[(N//2)])
# 최빈값을 구하기위해 Count를 가져옴
li = Counter(numbers).most_common(2)
if len(li) > 1 and li[0][1] == li[1][1]:
    print(li[1][0])
else:
    print(li[0][0])
print(max(numbers) - min(numbers))
