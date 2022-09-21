# 10768번 특별한 날
m = int(input())
d= int(input())

if [m, d] > [2, 18]:
    print("After")
elif [m, d] == [2, 18]:
    print("Special")
else:
    print("Before")
