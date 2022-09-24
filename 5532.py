# 5532번 방학 숙제
L = int(input())
# 국어
A = int(input())
# 수학
B = int(input())
# 하루에 풀 수 있는 국어 숙제의 최대치 
C = int(input())
# 하루에 풀 수 있는 수학 숙제의 최대치 
D = int(input())

# 숙제를 해야하는 일 수
ans = 0

if A//C > B//D:
    ans += A//C
    # 숙제를 하루에 최대치씩만 진행했을 때 남는 페이지 수
    if A%C != 0:
        ans += 1
else:
    ans += B//D
    # 숙제를 하루에 최대치씩만 진행했을 때 남는 페이지 수
    if B%D != 0:
        ans += 1

# 방학 일 수  - 숙제를 해야하는 일 수
print(L-ans)
