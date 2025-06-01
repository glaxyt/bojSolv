import sys

def solution():
    input = sys.stdin.readline
    n, m = map(int, input().split())
    memo = set()
    for _ in range(n):
        memo.add(input().strip())

    for _ in range(m):
        li = input().strip().split(',')
        for arg in li:
            if arg in memo:
                memo.remove(arg)
        print(len(memo))

solution()