# 10886번 0 = not cute / 1 = cute
t = int(input())
yes, no = 0, 0
for _ in range(t):
    n = input()
    if n == '1': yes += 1
    else: no += 1
if yes > no: print("Junhee is cute!")
else: print("Junhee is not cute!")
