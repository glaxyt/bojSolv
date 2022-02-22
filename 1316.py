# 1316번 그룹 단어 체커
t = int(input())
ans = t
for _ in range(t):
    n = input()
    for i in range(len(n)-1):
        if n[i] == n[i+1]:
            continue
        elif n[i] in n[i+1:]:
            ans -= 1
            break
print(ans)
        
