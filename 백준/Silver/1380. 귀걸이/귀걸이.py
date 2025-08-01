def solution():
    idx = 1
    while True:
        n = int(input())
        if n == 0:
            break

        students = []
        earrings = set()
        for _ in range(n):
           students.append(input())

        for _ in range(2 * n - 1):
            stud_idx, _ = input().split()
            if stud_idx not in earrings:
                earrings.add(stud_idx)
            else:
                earrings.remove(stud_idx)

        print(idx, students[int(earrings.pop())-1])
        idx += 1

solution()
