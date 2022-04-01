# 10987번 모음의 개수
vow = ['a','e','i','o','u']
word = input()
ans = 0
for i in vow:
    ans += word.count(i)
print(ans)
