# 6996번 애너그램
n = int(input())
for _ in range(n):
    a, b = input().split()
    s_a = sorted(a)
    s_b = sorted(b)

    if s_a == s_b:
        print(f'{a} & {b} are anagrams.')
    else:
        print(f'{a} & {b} are NOT anagrams.')
