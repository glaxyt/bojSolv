# 9465번 스티커
t = int(input())
for _ in range(t):
    n = int(input())
    # 누적값을 저장할 리스트이자 주어진 숫자를 저장해둔 리스트.
    dp = [list(map(int, input().split())) for _ in range(2)]
    # 초기값 설정 n이 1보다 큰 경우. 지그재그로 스티커를 찢었을 경우.
    if n > 1:
        dp[0][1] += dp[1][0]
        dp[1][1] += dp[0][0]
    # 지그재그로 찢은 경우 누적합 계산.
    for i in range(2, n):
        dp[0][i] += max(dp[1][i-2], dp[1][i-1])
        dp[1][i] += max(dp[0][i-2], dp[0][i-1])

    print(max(dp[0][n-1], dp[1][n-1]))
