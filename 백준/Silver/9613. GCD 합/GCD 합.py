 
## 조합 1,000,000 개가 사용된다. for문 사용 시에 시간초과 확률 상승
## 백트래킹 활용
temp = []

def gcd(n, m):
	while m > 0:
		n, m = m, n % m

	return n

def make_pair(idx, cnt):
	if cnt == 2:
		pairs.append(temp[:])
		return 

	for i in range(idx, num):
		if visited[i]:
			continue

		visited[i] = True
		temp.append(li[i])

		make_pair(i + 1, cnt + 1)

		visited[i] = False
		temp.pop()

t = int(input())
for _ in range(t):
	answer = 0
	pairs = []
	li = list(map(int, input().split()))
	num = li[0]
	li = li[1:]
	visited = [False for _ in range(num)]
	make_pair(0, 0)
	for a, b in pairs:
		answer += gcd(a, b)

	print(answer)