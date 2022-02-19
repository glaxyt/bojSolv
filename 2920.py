# 2920번 음계
numbers = list(map(int, input().split()))

asc = [1, 2, 3, 4, 5, 6, 7, 8]
dsc = list(reversed(asc))

if numbers == asc:
    print("ascending")
elif numbers == dsc:
    print("descending")
else:
    print("mixed")