def solution(n):
    answer = 0
    memo = [0 for _ in range(n)]
    memo[0] = 1
    memo[1] = 2
    
    for i in range(2, n):
        memo[i] = (memo[i-1] + memo[i-2]) % 1000000007
        
    return memo[n-1]