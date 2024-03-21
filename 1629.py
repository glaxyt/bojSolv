# 1629번 곱셈

a, n, c = map(int, input().split())
ans = 1

while n:
    # 만일 홀수 번 거듭제곱이 이뤄진다면 지수를 짝수로 만들어주기 위해
    # 답이 될 변수에 a를 한 번 곱해준다. n(지수)는 n //= 2에서 짝수로 만들어준다.
    if n % 2:
        ans *= a
        ans %= c
        
    a *= (a%c)
    n //= 2
    
print(ans)
