# 15904번 UCPC는 무엇의 약자일까?
word = input()
check = True

for i in "UCPC":
    if i in word:
        word = word[word.index(i)+1:]
    else:
        check = False
        break

if check: print("I love UCPC")
else: print("I hate UCPC")
