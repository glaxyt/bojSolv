import sys
from collections import deque
t = int(input())

# 실행어에 따른 문자열 처리
def use_function(queue, order):
    rev = 0
    for i in order:
        if i == "R":
            rev += 1
        elif i == 'D':
            if len(queue) == 0:
                return "error"
            else:
           		# 뒤집히지않았을 경우 popleft()로 첫문자를 제거해준다.
                if rev% 2 == 0:
                    queue.popleft()
                    
                # 뒤집혔을 경우 pop()로 첫문자를 제거해준다.
                else:
                    queue.pop()
	
    # 출력처리를 하기 위해 뒤집혔는지 확인한 뒤에 상황에 맞게 출력한다.
    if rev % 2 == 0:
        return f'[{",".join(queue)}]'
    else:
        queue.reverse()
        return f'[{",".join(queue)}]'

for _ in range(t):
    order = sys.stdin.readline().rstrip()
   	# 2번의 일련된 R실행은 다시 제자리로 찾아오기에 삭제해준다.
    order = order.replace('RR', '')
    n = int(sys.stdin.readline())
    nums = deque(sys.stdin.readline().rstrip()[1:-1].split(","))
    
    # 문자열이 아무것도 주어지지않았을 경우. 직접 deque를 비워준다.
    if n == 0:
        nums = deque([])
    print(use_function(nums, order))
