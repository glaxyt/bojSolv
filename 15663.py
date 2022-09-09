# 15663번 N과 M (9)
n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
ans = []
visited = [False] * n

def solve(cnt):
    if cnt == m:
        print(*ans)
        return
    temp = 0 # 수열 중복 처리를 위한 변수
    for i in range(n):
        if visited[i] == False and temp != nums[i]:  # 중복된 수열이라면 진행하지않는다.
            ans.append(nums[i])
            visited[i] = True
            temp = nums[i]
            solve(cnt+1)
            ans.pop()
            visited[i] = False

solve(0)
