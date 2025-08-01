from collections import defaultdict

def solution():
    n = int(input())

    heights_set = defaultdict(int)
    answer = 0

    for _ in range(n):
        x, y = map(int, input().split())
        for ex_h in heights_set.keys():
            if ex_h > y and heights_set[ex_h] > 0:
                answer += 1
                heights_set[ex_h] = 0
        if y != 0:
            heights_set[y] = 1

    for ex_h in heights_set.keys():
        if heights_set[ex_h] > 0:
            answer += 1

    print(answer)

solution()
