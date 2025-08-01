import sys

def solution():
    n = int(input())
    rocks = []
    for _ in range(n):
        rock_info = list(map(int, sys.stdin.readline().strip().split()))
        rocks.append(rock_info)

    prefer_quality_rocks = sorted(rocks, key = lambda x: (x[0], -x[1]), reverse = True)
    prefer_price_rocks = sorted(rocks, key = lambda x: (-x[1], x[0]), reverse = True)

    print(*prefer_quality_rocks[0], *prefer_quality_rocks[1])
    print(*prefer_price_rocks[0], *prefer_price_rocks[1])

solution()
