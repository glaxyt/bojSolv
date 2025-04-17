from collections import defaultdict

def solution(s):
    answer = [0] * (1000000)
    s = s.replace('{', '')
    s = s.replace('}', '')
    s = s.split(',')
    
    count = defaultdict(int)
    
    for i in s:
        count[i] += 1
    
    max_idx = 0
    for i in count.keys():
        num = count[i]
        answer[num] = int(i)
        max_idx = max(max_idx, num)
    # print(count)
    return answer[max_idx:0:-1]