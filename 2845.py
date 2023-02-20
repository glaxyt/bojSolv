# 2845번 파티가 끝나고 난 뒤
i, j = map(int, input().split())
total_num = i * j

li = list(map(int, input().split()))

for k in li:
    print(k - total_num, end=" ")
