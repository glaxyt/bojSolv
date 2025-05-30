def backtracking(cur, target):
    if len(cur) == len(target):
        if cur == target:
            print(1)
            exit()
        return

    if cur[-1] == 'A':
        backtracking(cur[:-1], target)
    
    if cur[0] == 'B':
        backtracking(cur[1:][::-1], target)


def solution():
    s = input()
    t = input()
    backtracking(t, s)
    print(0)

solution()
