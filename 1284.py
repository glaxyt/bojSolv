# 1284번 집 주소
import sys
while True:
    number = sys.stdin.readline().rstrip()
    if number == "0":
        break
    total = 2
    for i in number:
        if i == "1":
            total += 2
        elif i == "0":
            total += 4
        else:
            total += 3
    print(total + len(number)-1)
