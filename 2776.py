# 2776번 암기왕
t = int(input())
for _ in range(t):
    _ = int(input())
    note_1 = set(input().split())
    _ = int(input())
    note_2 = input().split()
    for i in note_2:
        if i in note_1:
            print(1)
        else:
            print(0)
