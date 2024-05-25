# 5525번 IOIOI
n = int(input())
m = int(input())
st = input()

c = 0
cnt = 0
ans = 0

while c < (m-1):
    if st[c:c+3] == 'IOI': #3칸
        cnt += 1
        c += 2
        if cnt == n:
            ans += 1
            cnt -= 1
    else:
        c += 1
        cnt = 0

print(ans)
