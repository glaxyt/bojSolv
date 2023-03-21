# 10811번 바구니 뒤집기
import sys
input = sys.stdin.readline
N, M = map(int, input().split())
bags = [i for i in range(1,N+1)]
for _ in range(M):
    i, j = map(int, input().split())
    bags = bags[:i-1]+ list(reversed(bags[i-1:j])) + bags[j:]
    
print(" ".join(list(map(str, bags))))
    
