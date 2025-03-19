def solution(m, n, puddles):
    answer = 0
    # m: 가로 n: 세로
    # (1, 1) -> (0, 0) 으로 처리 필요
    # m, n 도 -> m+1, n+1로 만들어주기
    ## 1,000,000,007 경로 나누기.
    ## 가면 안되는 지점 존재
    ## 오른쪽 아래쪽만 가능
    # 생각해보면 어디로 가든 최단 경로다. 무조건 아래 오른쪽이라면.
    grid = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    
    ## grid[x][y] = -1 이면 이동할 수 없는거리
    ## 사람마다 visited를 할당할 수는 없다 메모리 문제 발생
    ## 아 DP가 낫겠네..
        
    # 초기값 잡아주기
    # grid[0][i] = 1, grid[i][0] = 1로 세팅
#     for i in range(m):
#         if (i+1, 1) not in puddles:
#             grid[0][i] = 1
    
#     for j in range(n):
#         if (1, j + 1) not in puddles:
#             grid[j][0] = 1
    
    grid[1][1] = 1
    
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if (i, j) == (1, 1): continue
            if [j, i] not in puddles:
                grid[i][j] = (grid[i][j-1] + grid[i-1][j]) % 1000000007

    answer = grid[n][m]
    print(grid)
    # print("\n".join(grid))
    return answer