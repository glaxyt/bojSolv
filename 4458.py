# 4458번 첫 글자를 대문자로
n = int(input())
for _ in range(n):
    words = input()
    if 65 <= ord(words[0]) <= 90:
        print(words)
    else:
        chg = chr(ord(words[0])-32)
        print(chg + words[1:])
