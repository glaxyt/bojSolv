def solution():
    n = int(input())
    arr = [int(input()) for _ in range(n)]
    dp = [1] * n

    for i in range(1, n):
        for j in range(i):
            if arr[j] < arr[i]:
                dp[i] = max(dp[i], dp[j] + 1)

    lis_length = max(dp)
    print(n - lis_length)

solution()