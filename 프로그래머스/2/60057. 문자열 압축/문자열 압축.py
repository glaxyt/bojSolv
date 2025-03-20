def solution(s):
    answer = 1000
    # n등분 드가자.
    # .count()써볼까
    length = len(s)
    
    if length == 1:
        return 1
    
    for num in range(1, len(s)):
        total = length % num
        time = length // num
        idx = 0
        cnt = 1
        word = ""
        while idx < num * time:
            if idx == 0:
                word = s[idx : idx + num]
                idx += num
                continue
            
            if s[idx : idx + num] == word:
                cnt += 1
                
            else:
                if cnt > 1:
                    total += (len(str(cnt)) + num)
                else:
                    total += num
                    
                cnt = 1
                word = s[idx : idx + num]
                
            idx += num
        
        if cnt > 1:
            total += (len(str(cnt)) + num)
        else:
            total += num
            
        answer = min(answer, total)

    return answer