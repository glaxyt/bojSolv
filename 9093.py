# 9093번 단어 뒤집기
import sys
n = int(sys.stdin.readline())
for _ in range(n):
    words = sys.stdin.readline().split()
    for args in words:
        print(args[::-1], end=' ')
    print()
