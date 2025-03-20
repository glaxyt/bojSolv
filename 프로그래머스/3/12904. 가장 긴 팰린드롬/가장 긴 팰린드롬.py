def solution(s):
    answer = 1

    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    print('Hello Python')
    
    for i in range(len(s) - 1):
        for j in range(i + 1, len(s) + 1):
            word = s[i:j]
            if word == word[::-1]:
                answer = max(len(word), answer)
    return answer