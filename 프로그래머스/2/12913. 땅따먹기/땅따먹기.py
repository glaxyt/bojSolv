# 시작 시간 3:26
def solution(land):
    answer = 0
    visited = [True, False]
    land = [[0,0,0,0]] + land
    n = len(land)
    # 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고
    # 연속해서 밟지만 않으면 됨 직전의 열만 저장해두면 될 듯
    
    # 열에 최댓값이 여러개면? 우선 최댓값을 뽑아내는 프로세스를 어떻게 정해야할지가 중요하네
    # 100,000 * 4라서 시간 초과는 안날 것 같다.
    ## 어느 시점까지의 최댓값을 찾아야한다.
    for l in range(1, n):
        ## 땅의 크기는 자연수만 있음.
        for i in range(4):
            land[l][i] += max([land[l-1][j] for j in range(4) if i != j]) 

    answer = max(land[n-1])

    return answer