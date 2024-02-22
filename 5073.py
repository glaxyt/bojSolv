while 1:
    a, b, c = map(int, input().split())
    if a == 0:
        break
    li = sorted([a,b,c])
    length = len(set(li))
    if li[2] >= li[1] + li[0]:
        print("Invalid")
    else:
        if length == 1:
            print("Equilateral")
        elif length == 2:
            print("Isosceles")
        else:
            print("Scalene")
