## 100: 1 -> 10:1
## 18:24 -> 3:4

## 최대공약수를 구한다. -> 계산
## 계산한 값

def gcd(n, m):
	while m > 0:
		n, m = m, n % m

	return n


a, b = map(int, input().split(":"))
g = gcd(a, b)

print(f'{a // g}:{b // g}')