# 1972번 놀라운 문자열
ALERTS = ['is surprising.', 'is NOT surprising.']

while 1:
    word = input()
    if word == "*":
        break
    ALERTS_idx = 0
    # 문자열 확인 코드 작성.
    # 이중 for문을 활용하여서 for j in range(i, num)
    # 그러고 나서 set에 저장. 그러나 이미 존재한다면 break
    D = 1
    while D < len(word)-1:
        check_duplicate = set()
        for j in range(len(word)-D):
            fin_word = word[j] + word[j+D]
            if fin_word in check_duplicate:
                ALERTS_idx = 1
                break
            else:
                check_duplicate.add(fin_word)
        D += 1

    print(word, end = ' ')
    print(ALERTS[ALERTS_idx])