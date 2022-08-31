# 15652 N과 M (4)
import sys
sys.setrecursionlimit(10000)

N, M = map(int, input().split())
ans =[]
def print_ans():
    sys.stdout.write(f'{" ".join(map(str, ans))}\n')

def choose_num(num, cnt):
    # 재귀함수의 종료조건
    if num == M+1:
        print_ans()
        return
    # 재귀함수의 호출
    for i in range(cnt, N+1):
        ans.append(i)
        choose_num(num + 1, i)
        ans.pop()
    return

choose_num(1, 1)
