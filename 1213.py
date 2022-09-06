# 1213번 팰린드롬 만들기
import sys
from collections import Counter

word = list(input())
# 사전순으로 팰린드롬한 문자열을 출력하기 위해 미리 사전순으로 배열
word.sort()
# 문자열에 포함된 문자의 개수를 딕셔너리로 표현해주는 Counter 메서드
word_info = Counter(word)

# 팰린드롬이 가능한지 계산하는 함수
def is_it_Possible(word):
    # 문자열에 포함된 문자의 개수가 홀수인 문자의 개수
    cnt = 0
    # 개수가 홀수라서 출력될 문자열의 가운데를 차지할 문자
    middle = ""
    # 출력될 문자열의 왼쪽
    ans = ""
    for i in word_info:
        if word_info[i] % 2 != 0:
            cnt += 1
            middle += i
        
        # 문자의 개수의 반만큼 ans에 추가해준다.
        ans += i * (word_info[i] // 2)
        
        # 홀수의 개수를 가지는 문자가 1개 이상이면 팰린드롬이 불가능하다.
        if cnt > 1:
            # 팰린드롬 불가능
            return "I'm Sorry Hansoo"
    
    # 팰린드롬이 정상적으로 가능할 경우 답을 출력
    return ans + middle + ans[::-1]

print(is_it_Possible(word))
        
        
