# 2530번 인공지능 시계
h, m, s = map(int, input().split())
time = int(input())

total = (h*3600) + (m*60) + (s)
total += time

ans_h = total // 3600
total %= 3600
ans_m = total // 60
total %= 60

print(ans_h%24,  ans_m % 60, total)
