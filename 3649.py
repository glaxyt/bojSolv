# 3649번 로봇 프로젝트
import sys

while 1:
    try:
        x = int(input())
        x *= 10000000 # 단위가 센티미터이기에 나노미터로 통일.
        r = int(input())
        lego = [int(sys.stdin.readline()) for _ in range(r)]
        # r개수가 최대 10^6이기에 가능.
        lego.sort()
        start = 0
        end = r-1
        flag = False
        while start < end:
            total = lego[start] + lego[end]
            if total == x:
                flag = True
                break
            elif total > x:
                end -=1
            else:
                start += 1
        if flag:
            print("yes", lego[start], lego[end])
        else:
            print("danger")
    except:
        break
