def solution(n, money):
    ## 0원 만드는 방법 - 1가지
    ## 1원 만드는 방법 - 1가지 0
    ## 2원 1 + 1, 2 - 2가지 if currency == i: n[2] 1
    ## 3원 1 + 1 + 1, 2 + 1 - 2가지 / n[3-1] + n[3-2]:  1
    ## 4원 1 + 1 + 1 + 1, 2 + 2, 2 + 1 + 1 - 3가지 / n[4-1]+ n[4-2] = 2 + 
    ## 5원 1 + 1 + 1 + 1 + 1, 2 + 2 + 1, 2 + 1 + 1 + 1, 5 - 4가지
    dp = [1] + [0] * n
    for currency in money:
        for cur in range(currency, n + 1):
            dp[cur] += dp[cur - currency]
            
    return dp[n]