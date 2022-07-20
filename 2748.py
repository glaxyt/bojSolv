# 2748번 피보나치 수 2
n = int(input())
d = [0] * 91 # 테이블
d[1] = 1
d[2] = 1
if n < 2:
    print(d[n])
else:
    for i in range(3, n+1):
        d[i] = d[i-2] + d[i-1]
    print(d[n])
