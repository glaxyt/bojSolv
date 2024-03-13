# 10799번 쇠막대기
li = input()
stack = []
ans = 0
flag = ""
for i in li:
    if i == "(":
        stack.append(i)

    else:
        # i가 인접한() 레이저일 경우
        if flag == "(":
            stack.pop()
            ans += len(stack)
        # i가 쇠막대기의 끝점일 경우 경우
        elif flag == ")":
            stack.pop()
            ans += 1
            
    flag = i

print(ans)
