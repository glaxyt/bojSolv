## 
## 13시 54분 시작

## N = 3 seq = [-1, -2, -1000]
## 반례 찾음 2:31
## 답은 1999지만, 출력은 -998이 나옴

N = int(input())
seq = [int(input()) for _ in range(N)]

def Solution(N, seq):
    answer = 0
    pos = []
    neg = []
    zero = 0
    one = 0

    for num in seq:
        if num > 1:
            pos.append(num)
        elif num == 1:
            one += 1
        elif num == 0:
            zero += 1
        else:
            neg.append(num)
    ## 13시 54분 시작
    ## 음수는 짝이 있어야 곱한다.
    ## 0이 존재한다면, 적극적으로 이용한다.
    ## 오름차순을 이용한다.
    pos.sort(reverse = True)
    neg.sort()
    
    for i in range(0, len(pos) - 1, 2):
        answer += pos[i] * pos[i + 1]
    if len(pos) % 2 != 0:
        answer += pos[-1]

    for j in range(0, len(neg) - 1, 2):
        answer += neg[j] * neg[j + 1]
    if len(neg) % 2 != 0:
        if zero < 1:
            answer += neg[-1]

    answer += one
    print(answer)

Solution(N, seq)
