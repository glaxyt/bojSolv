# 10808번 알파벳 개수
word = input()
alphabet = [0]*26
for arg in word:
    alphabet[ord(arg)-97] += 1

for i in range(26):
    print(alphabet[i], end=' ')