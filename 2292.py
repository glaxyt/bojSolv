# 2292번 벌집
n = int(input())
if n == 1:  print(1)
else:
    cnt = 1
    while n > 1:
        n -= (cnt*6)
        cnt += 1
    print(cnt)
'''
1 1 - 1
2-7 6 - 2
8-19 12 - 3
20-37 18 - 4
38-61 24
'''