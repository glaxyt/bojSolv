s = input()
word = []
for i in range(len(s)):
    word.append(s[i:])
for j in sorted(word):
    print(j)
