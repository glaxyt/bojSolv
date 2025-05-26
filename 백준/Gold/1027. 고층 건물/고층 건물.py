import sys

def can_see(x1, y1, x2, y2, x3, y3):
  giulgi = (y2 - y1) / (x2 - x1)
  return giulgi * (x3 - x1) + y1 > y3
   
def solution():
  n = int(input())

  count = [0 for _ in range(n)]
  li = list(map(int, input().split()))
  
  # n은 50보다 같거나 작은 자연수 n^2 가능할듯
  for i in range(n - 1):
    for j in range(i + 1, n):
      flag = True

      ## 사이에 접하거나 막히는 건물이 있는지 확인
      for s in range(i + 1, j):
        if not can_see(i, li[i], j, li[j], s, li[s]):
          flag = False
          break

      if flag:
        count[i] += 1
        count[j] += 1

  print(max(count))

solution()