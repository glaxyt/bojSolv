# 2750번 수 정렬하기
n = int(input())
ans = []
for i in range(n):
    ans.append(int(input()))
ans.sort()
print("\n".join(map(str,ans)))
