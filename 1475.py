# 1475번 방 번호
room_num = input()
ans = 0
cur = 0
for i in range(10):
    if i == 6 or i == 9:
        cur = room_num.count(str(6)) + room_num.count(str(9))
        if cur % 2 != 0:
            cur += 1
        cur /= 2
            
    else:
        cur = room_num.count(str(i))
    ans = max(cur, ans)
print(int(ans))
