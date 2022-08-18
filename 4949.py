# 4949번 균형잡힌 세상
import sys
from collections import deque

def solve():
    for i in words:
        if i == "[" or i == "(":
            queue.append(i)
        elif i == "]":
            if queue and queue[-1] == "[":
                queue.pop()
            else:
                return "no"
        elif i == ")":
            if queue and queue[-1] == "(":
                queue.pop()
            else:
                return "no"
    # 주어진 문자열에 대한 탐색이 끝났는데도 덱에 "("나 "["가 남아있다면
    # 대칭된 문자가 존재하지 않는다는 것이다.
    if len(queue) == 0:
        return "yes"
    else:
        return "no"

while True:
    words = sys.stdin.readline().rstrip()
    if words == ".":
        break
    queue = deque([])
    print(solve())
