# 1075 나누기
n = int(input())
f = int(input())
n = (n - n % 100)
for i in range(n, n+100):
    if i % f == 0:
        print("".join(str(i)[-2:]))
        break
