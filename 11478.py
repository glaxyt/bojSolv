# 11478번 서로 다른 부분 문자열의 개수
t = input()
li = set()
length = len(t)
for space in range(1, length+1):
    for j in range(length-space+1):
        # 인덱스 기준
        li.add(t[j:j+space])
               
print(len(list(li)))
