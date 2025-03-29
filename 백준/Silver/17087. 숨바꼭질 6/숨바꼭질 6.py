n, s = map(int, input().split())
brothers_loc = list(map(int, input().split()))

for i in range(n):
    brothers_loc[i] = abs(brothers_loc[i] -s)

def gcd(n, m):
    while m > 0:
        n, m = m, n % m
    
    return n

answer = brothers_loc[0]

for i in range(1, n):
	answer = gcd(answer, brothers_loc[i])

print(answer)