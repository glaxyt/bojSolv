# 5397번 키로거

# 3:25시
t= int(input())
while 1:
    left_li = []
    right_li = []
    pwd = input()
    for i in pwd:
        if i == "-":
            if left_li:
                left_li.pop()
        elif i == ">":
            if right_li:
                left_li.append(right_li.pop())
        elif i == "<":
            if left_li:
                right_li.append(left_li.pop())
        else:
            left_li.append(i)
    
    left_li.extend(reversed(right_li))
    print(''.join(left_li))
        
