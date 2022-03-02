# 1065번 한수
n = int(input())
cnt = 0

def check(standard):
    for j in range(1, len(word)-1):
            if (int(word[j]) - int(word[j+1])) != standard:
                return False
    return True

for i in range(1, n+1):
    word = str(i)
    if len(word) <= 2:
        cnt += 1
    else:
        standard = int(word[0]) - int(word[1])
        if check(standard):
            cnt += 1
                
print(cnt)
