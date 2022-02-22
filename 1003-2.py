# 1003번 피보나치 함수
def fib(n):
    dp_0 = [1, 0, 1]
    dp_1 = [0, 1, 1]
    
    if n >= 3:
        for i in range(3, n+1):
            dp_0.append(dp_0[i-1] + dp_0[i-2])
            dp_1.append(dp_1[i-1] + dp_1[i-2])
    print(dp_0[n], dp_1[n])

t = int(input())
    
for _ in range(t):
    fib(int(input()))