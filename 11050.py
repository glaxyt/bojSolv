# 11050번 이항 계수 1
N, K = map(int, input().split())

def factorial(n):
    if n==0:
        return 1
    else:
        return n*factorial(n-1)

print(factorial(N) // (factorial(K)*factorial(N-K)))
