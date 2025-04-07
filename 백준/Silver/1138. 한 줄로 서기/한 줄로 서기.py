n = int(input())
li = list(map(int, input().split()))

def solution():
    line = [0] * n

    for height in range(1, n + 1):
        count = li[height - 1]
        idx = 0
        empty = 0

        while idx < n:
            if line[idx] == 0:
                if empty == count:
                    line[idx] = height
                    break
                empty += 1
            idx += 1

    return line

print(*solution())
