# 9084번 동전
import sys
input = sys.stdin.readline

t = int(input())
# 다이내믹 프로그래밍 사용
for _ in range(t):
    # 동전 종류의 개수
    _ = int(input())
    # 동전의 단위
    coin = list(map(int, input().split()))
    # 동전으로 만들어야할 금액
    k = int(input())
    # 다이내믹 프로그래밍 사용을 위한 메모제이션 사용
    dp = [0] * (k+1)
    dp[0] = 1

    for i in coin:
        for j in range(1, k+1):
            # 동전의 단위보다 큰 금액일 경우
            if j >= i:
                dp[j] += dp[j-i]

    print(dp[k])
    
