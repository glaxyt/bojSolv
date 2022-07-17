# 4153번 직각 삼각형
import sys
while 1:
    li = list(map(int, sys.stdin.readline().split()))
    if li == [0,0,0]:
         break
    li.sort() # 정렬을 통해서 리스트의 마지막 인덱스 자리에 제일 큰 수가 올 수 있게 합니다.
    if li[0]**2 + li[1]**2 == li[2]**2:     # 피타고라스 법칙 사용
        print("right")
    else:
        print("wrong")
