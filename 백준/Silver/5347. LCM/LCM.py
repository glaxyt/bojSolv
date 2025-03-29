def gcd(n, m):
    while m > 0:
        n, m = m, n % m
    return n

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    print(n * m  // gcd(n, m))