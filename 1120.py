# 1120번 문자열
a, b = input().split()
ans = 51	# 최솟값은 51이상인 아무 자연수로 설정해주셔도 좋습니다.
for j in range(len(b)-len(a)+1):
    k = 0
    for i in range(len(a)):
        if a[i] != b[i+j]:
            k += 1
    ans = min(k, ans)
print(ans)
