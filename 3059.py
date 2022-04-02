# 3059번 등장하지 않은 문자의 합
n = int(input())
for _ in range(n):
    word = input()
    ans =0
    for i in range(65, 91):
        if chr(i) in word:
            continue
        else:
            ans += i
    print(ans)
