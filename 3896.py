# 3986번 좋은 단어
import sys

t = int(input())
ans = 0
for _ in range(t):
    word = sys.stdin.readline().rstrip()
    stack = []
    for i in word:
        # 짝을 맞춰 볼 글자가 존재하지않다면 스택에 대기 시킨다.
        if not stack:
            stack.append(i)
        # 짝을 맞춰볼 글자가 존재한다면 비교해본다.
        else:
            # 짝이 맞다면 대기시킨 글자를 스택에서 제거
            if i == stack[-1]:
                stack.pop()
            # 짝이 맞지 않다면 글자를 스택에 대기시킨다.
            else:
                stack.append(i)

    # 스택이 비어있다면 모든 글자의 짝을 찾아줬기에 좋은 단어이다.
    if not stack:
        ans += 1

print(ans)
            
    
