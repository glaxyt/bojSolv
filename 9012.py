# 9012번 괄호
import sys
n = int(sys.stdin.readline())
for _ in range(n):
    stack = []
    word = sys.stdin.readline().rstrip()
    for i in word:
        if i == "(":
            stack.append(i)
        else:
            if len(stack) == 0:
                stack.append("0")
                break
            else:
                stack.pop()
                
    if len(stack) != 0:
        print("NO")
    else:
        print("YES")

    
