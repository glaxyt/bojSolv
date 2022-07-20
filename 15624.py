# 15624번 피보나치 수 7
n = int(input())
a = 0   # i-2 자리
b = 1   # i-1 자리

if n == 0:
    print(0)
else:
    for _ in range(2, n+1):
        a %= 1000000007
        b %= 1000000007
        a, b = b, a+b
          
    print(b%1000000007)
