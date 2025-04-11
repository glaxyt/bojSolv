n = int(input())

def solution():
    scores = [int(input()) for _ in range(n)]
    pre_num = scores.pop()
    answer = 0
    while scores:
        cur_num = scores.pop()
        if cur_num >= pre_num: 
            decrease = (cur_num - pre_num + 1)
            cur_num = pre_num - 1
            answer += decrease
        pre_num = cur_num
        
    return answer

print(solution())