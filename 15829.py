# 15829번 Hashing
n = int(input())
strings = input()
total = 0

# hasing을 하기 위해 사용된 함수 구현.
for i in range(n):
    total += ((ord(strings[i]) - 96) * (31 ** i))

print(total%1234567891)
