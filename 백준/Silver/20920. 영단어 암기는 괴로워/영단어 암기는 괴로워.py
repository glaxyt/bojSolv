import sys
from collections import defaultdict

input = sys.stdin.readline

def solution():
  ## 1. 자주 나오는 언어일수록 앞에 배치
  ## 2. 해당 언어의 길이가 길수록 앞에 배치
  ## 3. 알파벳 사전순
  answer = []
  appear = defaultdict(int)

  n, m = map(int, input().split())
  for _ in range(n):
    word = input().strip()

    if len(word) >= m:
      appear[word] += 1
  
  sorted_li = sorted(appear.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

  for info in sorted_li:
    print(info[0])

solution()