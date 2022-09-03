# 10820 문자열 분석
# 소문자 대문자 숫자 공백
import sys

while 1:
    words = sys.stdin.readline().rstrip('\n')
    
    if not words:
        break
    
    lower_case = 0
    upper_case = 0
    num = 0
    blank = 0
    for i in words:
        temp = ord(i)
        if temp == 32:
            blank += 1
        elif 48 <= temp <= 57:
            num += 1
        elif 97 <= temp <= 122:
            lower_case += 1
        else:
            upper_case += 1
    print(lower_case, upper_case, num, blank)

