# 28278번 스택 2
import sys
st = []

t = int(input())
for _ in range(t):
    order = sys.stdin.readline().rstrip().split()
    if len(order) == 2:
        st.append(order[1])
    else:
        if order[0] == "2":
            if st:
                print(st.pop())
            else:
                print(-1)
        elif order[0] == "3":
            print(len(st))
        elif order[0] == "4":
            if st:
                print(0)
            else:
                print(1)
        else:
            if st:
                print(st[-1])
            else:
                print(-1)
                
