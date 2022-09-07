# 15654번 N과 M (5)
import sys
sys.setrecursionlimit(10000)

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
ans = []
visited = [False] * N

def printAns():
    print(*ans)
    return

def choose_num(cur_cnt):
    # 재귀함수 종료조건
    if cur_cnt == M+1:
        printAns()
        return
    
    # 재귀함수 호출
    for  i in range(N):
        if visited[i]:
            continue
        visited[i] = True
        ans.append(nums[i])
        choose_num(cur_cnt+1)
        visited[i] = False
        ans.pop()
        
        
choose_num(1)
