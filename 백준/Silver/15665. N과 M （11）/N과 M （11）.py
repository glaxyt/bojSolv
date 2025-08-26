# 15665번
# 4시 22분

n, m = map(int, input().split())
nums = list(set(map(int, input().split())))
nums.sort()
answer = []
words = []

def solution():
  def backtracking(cnt):
    if cnt == m:
      answer.append(" ".join(map(str, words)))
      return

    for i in range(len(nums)):
      words.append(nums[i])

      backtracking(cnt+1)

      words.pop()
      
  backtracking(0)
  
  for ans in answer:
    print(ans)

solution()
