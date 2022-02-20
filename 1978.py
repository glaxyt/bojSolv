# 1978번 소수 찾기
_ = int(input())
ans = 0
numbers = list(map(int, input().split()))

def prime(x):
    for i in range(2, int(x**0.5)+1):
        if x % i == 0:
            return False
    return True

for i in numbers:
    if i == 1:
        continue
    if prime(i):
        ans += 1
print(ans)
