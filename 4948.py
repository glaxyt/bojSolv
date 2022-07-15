# 4948번 베르트랑 공준
import sys
def sieve():    # 에라토스테네스의 체 알고리즘.
    n = 123456*2
    arr = [True for _ in range(n+1)]
    for i in range(2, int(n**0.5)+1):
        if arr[i]:
            for j in range(i*2, n+1, i):
                arr[j] = False
    return arr   # 소수들의 목록을 반환
    
def solve():
    sosu_li = sieve()
    while True:
        k = int(sys.stdin.readline())
        if k==0:
            break
        n = 2*k
        ans = 0
        for i in range(n//2+1, n+1):    # 소수들의 개수를 계산하기위해 범위 조정
            if sosu_li[i]:
                ans += 1
        print(ans)
        
solve()
