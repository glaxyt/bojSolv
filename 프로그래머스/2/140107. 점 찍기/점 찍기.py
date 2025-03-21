def solution(k, d):
    answer = 0
    ## 원 공식 쓸까
    ## 2, 4라면, (2, 4) x 가능 
    ## 4등분한 원의 가능 점을 찾고 * 4
    ## y = (x - 16)^(0.5)
    
    for x in range(0, d + 1, k):
        y = int((d**2 - x**2)**0.5)
        answer += (y // k)  + 1
        
    return answer