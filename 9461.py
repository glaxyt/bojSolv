# 9461번 파도반 수열
t = int(input())
li = [1,1,1]
for i in range(3,101):
    li.append(li[i-3]+li[i-2])
for _ in range(t):
    n = int(input())
    print(li[n-1])
