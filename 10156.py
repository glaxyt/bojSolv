# 10156번 과자
s, k, m = map(int, input().split())
if m - (s*k) < 0:
    print((s*k)-m)
else:
    print(0)
