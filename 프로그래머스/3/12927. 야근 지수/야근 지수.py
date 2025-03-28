import heapq

def solution(n, works):
    answer = 0
    # 피로도 = 남은_일의_작업량_제곱
    # 1시 36분 시작
    ## 목표 N 시간 동안 야근 피로도를 최소화하는 것.
    ## 1시간 동안 작업량 1만큼 처리 가능하다면 퇴근까지 남은 N시간과 각 일에 대한 작업량
    ## 남는 야근 지수를 제곱한다.
    ## 그렇기 제일 큰 작업량을 줄이는게 목표.
    ## [4, 3, 3] -> 4를 3으로, 3을 2로, 3을 2로, 3을 2로
    ## [2, 1, 2] -> 2를 1로 1 + 1 + 4 = 6
    ## [1, 1] -> 0 기저조건: 모든 값이 0이면 종료
    revers_woks = [-i for i in works]
    heapq.heapify(revers_woks)
    
    while n > 0:
        # 최댓값을 max로 뽑을 것인가. n
        # 아니면 heap.pop이 나은가? long(n)
        # 따라서 여러번 뽑은 경우이기에 heapq 사용
        
        max_work = heapq.heappop(revers_woks)
        
        # 기저조건
        if max_work == 0:
            break
        # print("현재 최대 잔여 작업량", max_work, "주어진 남은 시간", n)
        n -= 1
        heapq.heappush(revers_woks, max_work + 1)
    
    answer = sum([i ** 2 for i in revers_woks])
    # print(answer)
        
    return answer