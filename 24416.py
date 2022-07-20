# 24416번 알고리즘 수업 - 피보나치 수 1
k = int(input())
ans_1 = 0
ans_2 = 0

def fib(n):
    global ans_1
    ans_1 += 1
    if (n == 1 or n == 2):
        return 1;
    else:
        return (fib(n - 1) + fib(n - 2));

def fibonacci(n):
    global ans_2
    f = [0] * 41
    f[1] = 1
    f[2] = 1
    for i in range(3, n+1):
        f[i] = f[i - 1] + f[i - 2]
        ans_2 += 1
    return ans_2;

print(f'{fib(k)} {fibonacci(k)}')
