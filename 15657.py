# 15657번 N과 M (8)
import sys
sys.setrecursionlimit(10000)

N, M = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
ans = []

def printAns():
    print(*ans)
    return

def choose_num(cur_cnt, start):
    # 재귀함수 종료조건
    if cur_cnt == M+1:
        printAns()
        return
    
    # 재귀함수 호출
    for  i in range(start, N):
        ans.append(nums[i])
        choose_num(cur_cnt+1, i)
        ans.pop()
        
        
choose_num(1, 0)
