# 11653번 소인수분해
n = int(input())
ans = []
def calc(c_n):
    for i in range(2, c_n):
        if n % i == 0:
            c_n = c_n // i
            ans.append(i)
            break
    return c_n

if n != 1:
    while True:
        t = calc(n)
        if n == t:
            ans.append(n)
            break
        n = t

print("\n".join(list(map(str, sorted(ans)))))
