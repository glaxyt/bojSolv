import sys

def solution():
    money = 5*(10**6)
    n = int(input())
    for _ in range(n):
        result = 0
        t = 1
        land = []
        while True:
            l = int(input())
            if l == 0:
                break
            land.append(l)

        land.sort(reverse=True)
        for t, p in enumerate(land, 1):
            result += 2*(p**t)

        if result <= money:
            print(result)
        else:
            print("Too expensive")

solution()
